package hello.itemservice.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.ObjectError;

import static org.assertj.core.api.Assertions.*;

public class MessageCodeResolverTest {

    // DefaultMessageCodesResolver 구현체
    MessageCodesResolver codesResolver = new DefaultMessageCodesResolver();

    @Test
    void messageCodeResolverObject() {
        String[] messageCodes = codesResolver.resolveMessageCodes("required", "item");
        assertThat(messageCodes).containsExactly("required.item", "required");
//        for (String messageCode : messageCodes) {
            //messageCode = required.item
            //messageCode = required
//            System.out.println("messageCode = " + messageCode);
    }

    @Test
    void messageCodesResolverField() {
        String[] messageCodes = codesResolver.resolveMessageCodes("required", "item", "itemName", String.class);
        //for (String messageCode : messageCodes) {
//            messageCode = required.item.itemName 객체명, 필드명
//            messageCode = required.itemName 필드명
//            messageCode = required.java.lang.String 타입
//            messageCode = required
            //System.out.println("messageCode = " + messageCode);
       // }
        assertThat(messageCodes).containsExactly(
                "required.item.itemName",
                "required.itemName",
                "required.java.lang.String",
                "required"
        );

    }


}

