package dk.dd.p2.soap.client;

import dk.dd.soap.client.NumberConversionLocator;
import dk.dd.soap.client.NumberConversionSoapType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SoapClientApplication
{
      public static void main(String[] args)
      {
            String inword = "";
            long nmb = 0;
            Scanner in;
            try
            {
                  NumberConversionLocator locator = new NumberConversionLocator();
                  NumberConversionSoapType service = locator.getNumberConversionSoap();
                  Scanner sin = new Scanner(System.in);
                  while ((nmb = sin.nextLong()) < 100)
                  {
                        inword = service.numberToWords(nmb);
                        System.out.println(inword);
                  }
            }
            catch (javax.xml.rpc.ServiceException ex)
            {
                  ex.printStackTrace();
            }
            catch (java.rmi.RemoteException ex)
            {
                  ex.printStackTrace();
            }
      }
}
