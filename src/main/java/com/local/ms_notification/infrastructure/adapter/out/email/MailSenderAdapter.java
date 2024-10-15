package com.local.ms_notification.infrastructure.adapter.out.email;

import com.local.ms_notification.application.port.out.MailSenderOutPutPort;
import com.local.ms_notification.infrastructure.adapter.out.listener.entity.Order;
import com.local.ms_notification.infrastructure.adapter.out.listener.entity.OrderLine;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@Configuration
@RequiredArgsConstructor
public class MailSenderAdapter implements MailSenderOutPutPort {
    public static final String TD_STYLE_BORDER_1_PX_SOLID_BLACK_PADDING_8_PX = "<td style='border: 1px solid black; padding: 8px;'>";
    public static final String TD = "</td>";
    public static final String CONSTANT_2_F = "$%.2f";
    private final JavaMailSender mailSender;
    @Value("${mail.send.notification.email}")
    private String email;
    @Value("${spring.mail.username}")
    private String from;

    @Override
    public void sendEmail(Order order) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        helper.setTo(email);
        helper.setSubject("Encargo para "+order.getCustomerDocument());
        helper.setText(buildOrderEmailBody(order),true);
        helper.setFrom(from);
        mailSender.send(mimeMessage);

    }


    public String buildOrderEmailBody(Order order) {
        StringBuilder emailBody = new StringBuilder();

        emailBody.append("<html>")
                .append("<body>")
                .append("<h2>Order Confirmation - Order ID: ").append(order.getId()).append("</h2>")
                .append("<p>Hola Julio,</p>")
                .append("<p>Un nuevo encargo ha sido generado abajo encontraras el detalle de cada producto:</p>")
                .append("<table style='border: 1px solid black; border-collapse: collapse;'>")
                .append("<thead>")
                .append("<tr>")
                .append("<th style='border: 1px solid black; padding: 8px;'>Product Name</th>")
                .append("<th style='border: 1px solid black; padding: 8px;'>Quantity</th>")
                .append("<th style='border: 1px solid black; padding: 8px;'>Price</th>")
                .append("<th style='border: 1px solid black; padding: 8px;'>Subtotal</th>")
                .append("</tr>")
                .append("</thead>")
                .append("<tbody>");

        for (OrderLine orderline : order.getOrderLines()) {
            emailBody.append("<tr>")
                    .append(TD_STYLE_BORDER_1_PX_SOLID_BLACK_PADDING_8_PX).append(orderline.getName()).append(TD)
                    .append(TD_STYLE_BORDER_1_PX_SOLID_BLACK_PADDING_8_PX).append(orderline.getQuantity()).append(TD)
                    .append(TD_STYLE_BORDER_1_PX_SOLID_BLACK_PADDING_8_PX).append(String.format(CONSTANT_2_F, orderline.getPrice())).append(TD)
                    .append(TD_STYLE_BORDER_1_PX_SOLID_BLACK_PADDING_8_PX).append(String.format(CONSTANT_2_F, orderline.getSubtotal())).append(TD)
                    .append("</tr>");
        }

        emailBody.append("</tbody>")
                .append("</table>")
                .append("<p>Total: <strong>").append(String.format(CONSTANT_2_F, order.getTotalPrice())).append("</strong></p>")
                .append("<p>Thank you!</p>")
                .append("</body>")
                .append("</html>");

        return emailBody.toString();
    }
}
