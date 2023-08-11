package com.vinicius.sbootapiinternetbankingapp.service.transactions;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.vinicius.sbootapiinternetbankingapp.entities.transactions.PixTransaction;
import com.vinicius.sbootapiinternetbankingapp.repository.transactions.PixTransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.twilio.type.PhoneNumber;

@Service
@Slf4j
public class CallerSmsPixNotificationServuce {

    @Value("${twilio.sid}")
    private String twilioSid;

    @Value("${twilio.key}")
    private String twilioKey;

    @Value("${twilio.phone.from}")
    private String twilioPhoneFrom;

    @Value("${twilio.phone.to}")
    private String twilioPhoneTo;

    @Autowired
    private PixTransactionRepository pixTransactionRepository;

    public void sendSms(Long pixId) {

        PixTransaction pixTransaction = pixTransactionRepository.findById(pixId).get();

        String date = pixTransaction.getDate().getMonthValue() + "/" + pixTransaction.getDate().getDayOfMonth()
                                                + "/" + pixTransaction.getDate().getYear();
        String messageVendor = "Você recebeu uma transferência via PIX de:  "
                + pixTransaction.getSenderAccount() + " realizado na data de:  " + date
                    + " no valor de: R$ " + String.format("%.2f", pixTransaction.getAmount());
        Twilio.init(twilioSid, twilioKey);

        PhoneNumber to = new PhoneNumber(twilioPhoneTo);
        PhoneNumber from = new PhoneNumber(twilioPhoneFrom);

        Message message = Message.creator(to, from, messageVendor).create();
        log.info("Message received: " + message);

    }
}
