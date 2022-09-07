package dk.dd.demo;

import com.sun.deploy.net.HttpResponse;
import org.hibernate.dialect.identity.JDataStoreIdentityColumnSupport;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import javax.swing.plaf.basic.BasicTextUI;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DemoOps
{
    private static BasicTextUI HttpClientBuilder;
    static final String endPointGetAll = "http://localhost:8063/students/";
    static final String endPointGetOne = "http://localhost:8063/students/{id}";
    static final String endPointSave = "http://localhost:8063/students/";
    static final String endPointUpdateId = "http://localhost:8063/students/{id}";
    static final String endPointDelete = "http://localhost:8063/students/{id}";


    public static void main(String[] args)
    {
        // RestTemplate is a class, which provides template for making HTTP requests to RESTful services
        RestTemplate restTemplate = new RestTemplate();

        // JSON values
        Map<String, String> params = new HashMap<String, String>();

        // HTTP request object
        HttpRequest request = null;
        // HTTP response object
        HttpResponse response = null;
        String result;

        // Simple HTTP GET commands
        ResponseEntity<Student> string = restTemplate.getForEntity(endPointGetOne, Student.class, 2);
        System.out.println(string.getHeaders());
        Object[] results = restTemplate.getForObject(endPointGetAll, Object[].class);
        System.out.println(results);

        // Simple HTTP POST command
        Student newStudent = new Student(4000, "Donny", "don@email.com");
        ResponseEntity<String> entity = restTemplate.postForEntity(endPointSave, newStudent, String.class, params);

        // Put
        params.put("id", "3");
        Student updatedStudents = new Student(10, "Dolly", "test@email.com");
        restTemplate.put(endPointUpdateId, updatedStudents, params);

        // Delete
        params.put("id", "16");
        restTemplate.delete(endPointDelete, params);


        // Managing HttpHeaders
        HttpHeaders headers = new HttpHeaders();

        // Preparing the headers
        headers.set("MyRESTtest", "REST TEST");
        // Client wants to send request in JSON format
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        // Client expects response in JSON format
        headers.setContentType(MediaType.APPLICATION_JSON);

        // The response is a set of strings
        HttpEntity<String> entit = new HttpEntity<String>("parameters", headers);

        ResponseEntity<String> respo = restTemplate.exchange(endPointGetAll, HttpMethod.GET, entit, String.class);
        HttpStatus statusCode = respo.getStatusCode();
        System.out.println("Status code: " + statusCode);

        // Alternative to restTemplate: HttpClientBuilder
        // Send request and headers with GET method, then consume the response
        // response = HttpClientBuilder.create().build().execute(request);
    }
}
