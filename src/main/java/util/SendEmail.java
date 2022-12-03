package util;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.User;

import java.util.Properties;
import java.util.Random;



public class SendEmail {
    public String getRandom() {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return String.format("%06d", number);
    }

    //send email to the user email
    public boolean sendEmail(User user) {
        boolean test = false;

        String toEmail = user.getEmail();
        String fromEmail = "nhatrothuongtam@gmail.com";
        String password = "dyhpsnpyuxfvvoka";

        try {

            // your host email smtp server details
            Properties pr = new Properties();
            pr.setProperty("mail.smtp.host", "smtp.gmail.com");
            pr.setProperty("mail.smtp.port", "587");
            pr.setProperty("mail.smtp.auth", "true");
            pr.setProperty("mail.smtp.starttls.enable", "true");
            pr.put("mail.smtp.ssl.trust", "*");
            pr.put("mail.smtp.socketFactory.port", "587");
            pr.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

            //get session to authenticate the host email address and password
            Session session = Session.getInstance(pr, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            });

            //set email message details
            Message mess = new MimeMessage(session);

            //set from email address
            mess.setFrom(new InternetAddress(fromEmail));
            //set to email address or destination email address
            mess.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
    
            //set email subject
            mess.setSubject("Thông báo đăng kí nhà trọ thành công");
            long millis=System.currentTimeMillis();
            java.sql.Date nowDate=new java.sql.Date(millis);

            //set message text

//            mess.setText("Registered successfully.Please verify your account using this code: " + email);
            mess.setContent("<!DOCTYPE html PUBLIC  \"-//W3C//DTD XHTML 1.0 Strict//EN \"  \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd \"> \r\n"
            		+ "    <html xmlns= \"http://www.w3.org/1999/xhtml \" lang= \"vi \"> \r\n"
            		+ "                        <head> \r\n"
            		+ "                            <meta http-equiv= \"Content-Type \" content= \"text/html; charset=utf-8 \" /> \r\n"
            		+ "                            <title>Email Template for Order Confirmation Email</title> \r\n"
            		+ "                             \r\n"
            		+ "                            <!-- Start Common CSS --> \r\n"
            		+ "                            <style type= \"text/css \"> \r\n"
            		+ "                                #outlook a {padding:0;} \r\n"
            		+ "                                body{width:100% !important; -webkit-text-size-adjust:100%; -ms-text-size-adjust:100%; margin:0; padding:0; font-family: Helvetica, arial, sans-serif;} \r\n"
            		+ "                                .ExternalClass {width:100%;} \r\n"
            		+ "                                .ExternalClass, .ExternalClass p, .ExternalClass span, .ExternalClass font, .ExternalClass td, .ExternalClass div {line-height: 100%;} \r\n"
            		+ "                                .backgroundTable {margin:0; padding:0; width:100% !important; line-height: 100% !important;} \r\n"
            		+ "                                .main-temp table { border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt; font-family: Helvetica, arial, sans-serif;} \r\n"
            		+ "                                .main-temp table td {border-collapse: collapse;} \r\n"
            		+ "                            </style> \r\n"
            		+ "                            <!-- End Common CSS --> \r\n"
            		+ "                        </head> \r\n"
            		+ "                        <body> \r\n"
            		+ "                            <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" class=\"backgroundTable main-temp\" style=\"background-color: #d5d5d5;\"> \r\n"
            		+ "                                <tbody> \r\n"
            		+ "                                    <tr> \r\n"
            		+ "                                        <td> \r\n"
            		+ "                                            <table width= \"600 \" align= \"center \" cellpadding= \"15 \" cellspacing= \"0 \" border= \"0 \" class= \"devicewidth \" style=\"background-color: #ffffff;\"> \r\n"
            		+ "                                                <tbody> \r\n"
            		+ "                                                <!-- Start header Section --> \r\n"
            		+ "                                                    <tr> \r\n"
            		+ "                                                        <td style= \"padding-top: 30px; \"> \r\n"
            		+ "                                                            <table width= \"560 \" align= \"center \" cellpadding= \"0 \" cellspacing= \"0 \" border= \"0 \" class=\"devicewidthinner\" style=\"border-bottom:1px solid #eeeeee; text-align:center;  margin-left: 80px; \"> \r\n"
            		+ "                                                                <tbody> \r\n"
            		+ "                                                                    <tr> \r\n"
            		+ "                                                                        <td style= \"padding-bottom: 10px; \"> \r\n"
            		+ "                                                                            <img src= \"https://res.cloudinary.com/dvzn6yadj/image/upload/v1669996479/LT_Web/avt_dqcoko.jpg\" width=\"199px\" alt= \"logo\" />\r\n"
            		+ "                                                                        </td> \r\n"
            		+ "                                                                    </tr> \r\n"
            		+ "                                                                    <tr> \r\n"
            		+ "                                                                        <td style= \"font-size: 18px; line-height: 18px; color: #060606; padding-bottom: 5px;\"> \r\n"
            		+ "                                                                            <strong>Hoa Don Dang Ky Nha Tro</strong>  \r\n"
            		+ "                                                                        </td> \r\n"
            		+ "                                                                    </tr>\r\n"
            		+ "\r\n"
            		+ "                                                                    <tr> \r\n"
            		+ "                                                                        <td style= \"font-size: 14px; line-height: 18px; color: #666666; \"> \r\n"
            		+ "                                                                            Thu Duc, Viet Nam, 84 \r\n"
            		+ "                                                                        </td> \r\n"
            		+ "                                                                </tr> \r\n"
            		+ "                                                                  <tr> \r\n"
            		+ "                                                                        <td style= \"font-size: 14px; line-height: 18px; color: #666666; \"> \r\n"
            		+ "                                                                            Phone: +84 377019134 | Email:  \"nhatrothuongtam@gmail.com\" \r\n"
            		+ "                                                                        </td> \r\n"
            		+ "                                                                    </tr> \r\n"
            		+ "                                                                    <tr> \r\n"
            		+ "                                                                        <td style= \"font-size: 14px; line-height: 18px; color: #666666; padding-bottom: 15px; \"> \r\n"
            		+ "                                                                            <strong>Order Date:</strong> \""+ nowDate +"\" \r\n"
            		+ "                                                                        </td> \r\n"
            		+ "                                                                    </tr>\r\n"
            		+ "                                                                    </tr> \r\n"
            		+ "                                                                </tbody> \r\n"
            		+ "                                                            </table> \r\n"
            		+ "                                                        </td> \r\n"
            		+ "                                                    </tr> \r\n"
            		+ "                                                    <!-- End header Section --> \r\n"
            		+ "\r\n"
            		+ "                                                      <!-- Start payment method Section --> \r\n"
            		+ "                                                      <tr> \r\n"
            		+ "                                                        <td style= \"padding: 0 10px; \"> \r\n"
            		+ "                                                            <table width= \"560 \" align= \"center \" cellpadding= \"0 \" cellspacing= \"0 \" border= \"0 \" class= \"devicewidthinner \" style= \"margin-left: 80px; \"> \r\n"
            		+ "                                                                <tbody> \r\n"
            		+ "                                                                    <tr> \r\n"
            		+ "                                                                        <td colspan= \"2 \" style= \"font-size: 16px; font-weight: bold; color: #666666; padding-bottom: 5px; \"> \r\n"
            		+ "                                                                            Payment Syntax \r\n"
            		+ "                                                                        </td> \r\n"
            		+ "                                                                    </tr> \r\n"
            		+ "                                                                    <tr> \r\n"
            		+ "                                                                        <td style= \"width: 55%; font-size: 14px; line-height: 18px; color: #666666; \"> \r\n"
            		+ "                                                                            Syntax: <strong>\"DK_Ten Nha Tro_UserName\"</strong>\r\n"
            		+ "                                                                        </td> \r\n"
            		+ "\r\n"
            		+ "                                                                    </tr> \r\n"
            		+ "                                                                    <tr> \r\n"
            		+ "                                                                        <td style= \"width: 55%; font-size: 14px; line-height: 18px; color: #666666; \"> \r\n"
            		+ "                                                                            Momo: <strong>0377019134</strong>\r\n"
            		+ "                                                                        </td> \r\n"
            		+ "                                                                    </tr> \r\n"
            		+ "                                                                    <tr> \r\n"
            		+ "                                                                        <td style= \"width: 55%; font-size: 14px; line-height: 18px; color: #666666; \"> \r\n"
            		+ "                                                                            Price: <strong>0.5$</strong>\r\n"
            		+ "                                                                        </td> \r\n"
            		+ "                                                                    </tr>\r\n"
            		+ "                                                                    <tr> \r\n"
            		+ "                                                                        <td style= \"width: 55%; font-size: 13px; line-height: 32px; color: #666666; padding-bottom: 0px;\"> \r\n"
            		+ "                                                                            <strong>AFTER PAYMENT, YOUR POST WILL BE UPDATED IN 1H!</strong> \r\n"
            		+ "                                                                            <!-- <strong>(SAU KHI THANH TOAN BAI DANG SE DUOC CAP NHAT TRONG 1H!)</strong> -->\r\n"
            		+ "                                                                        </td>                      \r\n"
            		+ "                                                                    </tr> \r\n"
            		+ "                                                                    <tr> \r\n"
            		+ "                                                                        <td colspan= \"2 \" style= \"width: 100%; text-align: center; font-style: italic; font-size: 13px; font-weight: 600; color: #666666; padding: 8px 0; border-top: 1px solid #eeeeee; \"> \r\n"
            		+ "                                                                        </td> \r\n"
            		+ "                                                                    </tr> \r\n"
            		+ "                                                                </tbody> \r\n"
            		+ "                                                            </table> \r\n"
            		+ "                                                        </td> \r\n"
            		+ "                                                    </tr> \r\n"
            		+ "                                                    <!-- End payment method Section --> \r\n"
            		+ "                                                     \r\n"
            		+ "                                                    <!-- Start address Section --> \r\n"
            		+ "                                                    <tr> \r\n"
            		+ "                                                        <td style= \"padding-top: 0; \"> \r\n"
            		+ "                                                            <table width= \"560 \" align= \"center \" cellpadding= \"0 \" cellspacing= \"0 \" border= \"0 \" class= \"devicewidthinner \" style= \"border-bottom: 1px solid #eeeeee; margin-left: 74px; \"> \r\n"
            		+ "                                                                <tbody> \r\n"
            		+ "                                                                    <tr> \r\n"
            		+ "                                                                        <td style= \"width: 55%; font-size: 16px; font-weight: bold; color: #666666; padding-bottom: 5px; \"> \r\n"
            		+ "                                                                            Delivery Adderss \r\n"
            		+ "                                                                        </td> \r\n"
            		+ "                                                                        <td style= \"width: 45%; font-size: 16px; font-weight: bold; color: #666666; padding-bottom: 5px; \"> \r\n"
            		+ "                                                                            Billing Address \r\n"
            		+ "                                                                        </td> \r\n"
            		+ "                                                                    </tr> \r\n"
            		+ "                                                                    <tr> \r\n"
            		+ "                                                                        <td style= \"width: 55%; font-size: 14px; line-height: 18px; color: #666666; \"> \r\n"
            		+ "                                                                            So 1, Vo Van Ngan \r\n"
            		+ "                                                                        </td> \r\n"
            		+ "                                                                        <td style= \"width: 45%; font-size: 14px; line-height: 18px; color: #666666; \"> \r\n"
            		+ "                                                                             \r\n"
            		+ "                                                                        </td> \r\n"
            		+ "                                                                    </tr> \r\n"
            		+ "                                                                    <tr> \r\n"
            		+ "                                                                        <td style= \"width: 55%; font-size: 14px; line-height: 18px; color: #666666; \"> \r\n"
            		+ "                                                                            Phuong Linh Chieu \r\n"
            		+ "                                                                        </td> \r\n"
            		+ "                                                                        <td style= \"width: 45%; font-size: 14px; line-height: 18px; color: #666666; \"> \r\n"
            		+ "                                                                            dia chi \r\n"
            		+ "                                                                        </td> \r\n"
            		+ "                                                                    </tr> \r\n"
            		+ "                                                                    <tr> \r\n"
            		+ "                                                                        <td style= \"width: 55%; font-size: 14px; line-height: 18px; color: #666666; padding-bottom: 10px; \"> \r\n"
            		+ "                                                                            Thanh Pho Thu Duc, Viet Nam  \r\n"
            		+ "                                                                        </td> \r\n"
            		+ "                                                                        <td style= \"width: 45%; font-size: 14px; line-height: 18px; color: #666666; padding-bottom: 10px; \"> \r\n"
            		+ "                                                                            Viet Nam \r\n"
            		+ "                                                                        </td> \r\n"
            		+ "                                                                    </tr> \r\n"
            		+ "                                                                </tbody> \r\n"
            		+ "                                                            </table> \r\n"
            		+ "                                                        </td> \r\n"
            		+ "                                                    </tr> \r\n"
            		+ "                                                    <!-- End address Section --> \r\n"
            		+ "                                                     \r\n"
            		+ "                              \r\n"
            		+ "                                                    <!-- Start payment method Section --> \r\n"
            		+ "                                                    <tr> \r\n"
            		+ "                                                        <td style= \"padding: 0 10px; \"> \r\n"
            		+ "                                                            <table width= \"560 \" align= \"center \" cellpadding= \"0 \" cellspacing= \"0 \" border= \"0 \" class= \"devicewidthinner \" style= \"margin-left: 80px; \"> \r\n"
            		+ "                                                                <tbody> \r\n"
            		+ "                                                                    <tr> \r\n"
            		+ "                                                                        <td colspan= \"2 \" style= \"font-size: 16px; font-weight: bold; color: #666666; padding-bottom: 5px; \"> \r\n"
            		+ "                                                                            Detail Receipt \r\n"
            		+ "                                                                        </td> \r\n"
            		+ "                                                                    </tr> \r\n"
            		+ "                                                                    <tr> \r\n"
            		+ "                                                                        <td style= \"width: 55%; font-size: 14px; line-height: 18px; color: #666666; \"> \r\n"
            		+ "                                                                            Name: "+ user.getName() +" \r\n"
            		+ "                                                                        </td> \r\n"
            		+ "                                                                    <td style= \"width: 45%; font-size: 14px; line-height: 18px; color: #666666; \"> \r\n"
            		+ "                                                                            Phone:  \r\n"
            		+ "                                                                        </td> \r\n"
            		+ "                                                                    </tr> \r\n"
            		+ "                                                                    <tr> \r\n"
            		+ "                                                                        <td style= \"width: 55%; font-size: 14px; line-height: 18px; color: #666666; \"> \r\n"
            		+ "                                                                            Email:  "+ user.getEmail() +" \r\n"
            		+ "                                                                        </td> \r\n"
            		+ "                                                                        <td style= \"width: 45%; font-size: 14px; line-height: 18px; color: #666666; \"> \r\n"
            		+ "                                                                            Date:  \r\n"
            		+ "                                                                        </td> \r\n"
            		+ "                                                                    </tr> \r\n"                                                                
            		+ "                                                                    <tr> \r\n"
            		+ "                                                                        <td colspan= \"2 \" style= \"width: 100%; text-align: center; font-style: italic; font-size: 13px; font-weight: 600; color: #666666; padding: 15px 0; border-top: 1px solid #eeeeee; \"> \r\n"
            		+ "                                                                            <b style= \"font-size: 14px; \">Note:</b> Thank you for using our service\r\n"
            		+ "                                                                        </td> \r\n"
            		+ "                                                                    </tr> \r\n"
            		+ "                                                                </tbody> \r\n"
            		+ "                                                            </table> \r\n"
            		+ "                                                        </td> \r\n"
            		+ "                                                    </tr> \r\n"
            		+ "                                                    <!-- End payment method Section --> \r\n"
            		+ "                                                </tbody> \r\n"
            		+ "                                            </table> \r\n"
            		+ "                                        </td> \r\n"
            		+ "                                    </tr> \r\n"
            		+ "                                </tbody> \r\n"
            		+ "                            </table> \r\n"
            		+ "                        </body> \r\n"
            		+ "                    </html>","text/html");

//            //send the message
            Transport.send(mess);

            test=true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return test;
    }
}