package guru.framework.springmvcrest.websockets.bean;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MessageBeanTest {

    private MessageBean bean =new MessageBean();

    @Test
    void getName() {
        bean.setName("test");
        assertTrue(bean.getName() == "test");
    }

    @Test
    void setName() {
        bean.setName("test");
        assertEquals("test", bean.getName());
    }

    @Test
    void getMessage() {
        bean.setMessage("test");
        assertTrue(bean.getMessage() == "test");
    }

    @Test
    void setMessage() {
        bean.setMessage("test");
        assertEquals("test", bean.getMessage());
    }
}