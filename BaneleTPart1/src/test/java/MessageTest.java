/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.baneletpart1.Message;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Part 2 (the Message class), using the test data from the brief.
 *
 * The message ID is normally random. For the hash tests we use a fixed ID that
 * starts with "00", so the expected hash "00:0:HITONIGHT" can be checked.
 *
 * @author Kgomotso
 */
public class MessageTest {

    //Test data for Message 1 (from the brief)
    String recipient1 = "+27718693002";
    String message1 = "Hi Mike, can you join us for dinner tonight?";

    //Test data for Message 2 (from the brief)
    String recipient2 = "08575975889";
    String message2 = "Hi Keegan, did you receive the payment?";

    //Fixed message ID for testing the hash
    String testID = "0012345678";

    public MessageTest() {

    }

    //==================The message should not be more than 250 characters==================

    @Test
    public void checkMessageLengthSuccess() {
        Message messageObj = new Message(testID, 0, recipient1, message1);
        String expected = "Message ready to send.";
        String actual = messageObj.checkMessageLength(message1);

        assertEquals(expected, actual);
    }

    @Test
    public void checkMessageLengthFailure() {
        //Building a message that is 260 characters long (10 too many)
        String longMessage = "";
        for (int i = 0; i < 260; i++) {
            longMessage += "a";
        }

        Message messageObj = new Message(testID, 0, recipient1, message1);
        String expected = "Message exceeds 250 characters by 10; please reduce the size.";
        String actual = messageObj.checkMessageLength(longMessage);

        assertEquals(expected, actual);
    }

    //==================The recipient number is correctly formatted==================

    @Test
    public void checkRecipientCellSuccess() {
        Message messageObj = new Message(testID, 0, recipient1, message1);
        String expected = "Cell phone number successfully captured.";
        String actual = messageObj.checkRecipientCell(recipient1);

        assertEquals(expected, actual);
    }

    @Test
    public void checkRecipientCellFailure() {
        Message messageObj = new Message(testID, 1, recipient2, message2);
        String expected = "Cell phone number is incorrectly formatted or does not contain an international code. "
                + "Please correct the number and try again.";
        String actual = messageObj.checkRecipientCell(recipient2);

        assertEquals(expected, actual);
    }

    //==================Message hash is correct==================

    @Test
    public void checkMessageHashTestCase1() {
        Message messageObj = new Message(testID, 0, recipient1, message1);
        String expected = "00:0:HITONIGHT";
        String actual = messageObj.createMessageHash(testID, 0, message1);

        assertEquals(expected, actual);
    }

    @Test
    public void checkMessageHashesInLoop() {
        //Testing the rest of the message hashes in a loop
        String[] messages = {message1, message2};
        String[] expectedHashes = {"00:0:HITONIGHT", "00:1:HIPAYMENT"};

        Message messageObj = new Message(testID, 0, recipient1, message1);

        for (int i = 0; i < messages.length; i++) {
            String actual = messageObj.createMessageHash(testID, i, messages[i]);
            assertEquals(expectedHashes[i], actual);
        }
    }

    //==================Message ID is created==================

    @Test
    public void checkMessageIDCreated() {
        String messageID = Message.generateMessageID();
        Message messageObj = new Message(messageID, 0, recipient1, message1);

        String expected = "Message ID generated: " + messageID;
        String actual = messageObj.messageIDCreated();

        assertEquals(expected, actual);
    }

    @Test
    public void checkMessageIDIsValid() {
        String messageID = Message.generateMessageID();
        Message messageObj = new Message(messageID, 0, recipient1, message1);

        assertTrue(messageObj.checkMessageID(messageID));
    }

    @Test
    public void checkMessageIDTooLong() {
        Message messageObj = new Message(testID, 0, recipient1, message1);

        assertFalse(messageObj.checkMessageID("12345678901"));
    }

    //==================MessageSent: Send, Disregard, Store==================

    @Test
    public void checkSendMessage() {
        Message messageObj = new Message(testID, 0, recipient1, message1);
        String expected = "Message successfully sent.";
        String actual = messageObj.SentMessage(1);

        assertEquals(expected, actual);
    }

    @Test
    public void checkDisregardMessage() {
        Message messageObj = new Message(testID, 1, recipient2, message2);
        String expected = "Press 0 to delete the message.";
        String actual = messageObj.SentMessage(2);

        assertEquals(expected, actual);
    }

    @Test
    public void checkStoreMessage() {
        Message messageObj = new Message(testID, 0, recipient1, message1);
        String expected = "Message successfully stored.";
        String actual = messageObj.SentMessage(3);

        assertEquals(expected, actual);
    }

    //==================Return total number sent==================

    @Test
    public void checkReturnTotalMessages() {
        //Test data: Message 1 is sent and Message 2 is discarded, so the total is 1
        ArrayList<Message> sentMessages = new ArrayList<>();
        Message messageObj1 = new Message(testID, 0, recipient1, message1);

        sentMessages.add(messageObj1);

        assertEquals(1, messageObj1.returnTotalMessages(sentMessages));
    }

    @Test
    public void checkPrintMessages() {
        ArrayList<Message> sentMessages = new ArrayList<>();
        Message messageObj1 = new Message(testID, 0, recipient1, message1);
        sentMessages.add(messageObj1);

        String expected = "Message ID: 0012345678"
                + "\nMessage Hash: 00:0:HITONIGHT"
                + "\nRecipient: +27718693002"
                + "\nMessage: Hi Mike, can you join us for dinner tonight?\n\n";
        String actual = messageObj1.printMessages(sentMessages);

        assertEquals(expected, actual);
    }
}
