package dk.dd.grpcstudent.grpcis.domain.service;

import dk.dd.grpcstudent.grpcis.dao.StudentDAO;
import dk.dd.grpcstudent.grpcis.domain.entity.Student;
import dk.dd.grpcstudent.grpcis.gRPCexamClient.ExamClient;
import dk.dd.grpcstudent.stubs.student.Grade;
import dk.dd.grpcstudent.stubs.student.StudentRequest;
import dk.dd.grpcstudent.stubs.student.StudentResponse;
import dk.dd.grpcstudent.stubs.student.StudentServiceGrpc;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

// We extend the autogenerated class and override the getStudentInfo() method defined in our proto service definition
// Here we will process the Request and build the Response of this service operation
@Service
public class StudentService extends StudentServiceGrpc.StudentServiceImplBase
{
    // Get access to the dao class for working with the database
    private StudentDAO studentDao = new StudentDAO();
    // Use logger to log what we decide to
    private static final Logger logger = Logger.getLogger(StudentService.class.getName());

    // Here we override the getStudentInfo()
    // StreamObserver<StudentResponse> is a response observer, provides an option to the client to make either a blocking or a non-blocking call
    @Override
    public void getStudentInfo(StudentRequest request, StreamObserver<StudentResponse> responseObserver)
    {
        // student ID is passed as a parameter of the request message
        String id = request.getId();
        try
        {
            // We need an instance of StudentDAO to access the Student database
            Student student = studentDao.findById(id);

            // *****************************************
            // We create additional method to extract gRPC data from the Exam service - gRPC ExamClient of the gRPC-exam server
            // We will use the data extracted from the gRPC-exam server to form the response, returned to the gRPC-student-ExamClient application
            List<String> examResponse = ExamClient.getConnected(id);
            // *********************************************

            // Once all the request data is available, we can build our response message
            StudentResponse studentResponse = StudentResponse.newBuilder()
                    .setId(id)
                    .setName(student.getName())
                    .setMail(student.getMail())
                    .setSi(Grade.valueOf(examResponse.get(0)))
                    .setDls(Grade.valueOf(examResponse.get(1)))
                   .setTst(Grade.valueOf(examResponse.get(2)))
                    .build();
            
            // We pass the created response object to the responseObserver's onNext() method to send it to the client
            responseObserver.onNext(studentResponse);
            // Finally, call onCompleted() to specify that we’ve finished dealing with the RPC connection
            responseObserver.onCompleted();
        }
        catch (NoSuchElementException e)
        {
            logger.log(Level.SEVERE, "NO STUDENT FOUND WITH THE STUDENT ID :- "+ id);

            // If some error occurs we sent an error with the following status which is not_found
            responseObserver.onError(Status.NOT_FOUND.asRuntimeException());
        }
    }

}


