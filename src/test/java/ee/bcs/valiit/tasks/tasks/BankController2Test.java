package ee.bcs.valiit.tasks.tasks;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class BankController2Test {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void newCustomer() throws Exception {
        //http://localhost:8081/bank2/newCustomer?name=Kristian
        mockMvc.perform(MockMvcRequestBuilders.get("/bank2/newCustomer?name=Kristian")
                .contentType("application/json")
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    void createAccount() throws Exception {
        //http://localhost:8081/bank2/createAccount?accountNr=EE123&customer_id=1
        mockMvc.perform(MockMvcRequestBuilders.get("/bank2/createAccount?accountNr=EE123&customer_id=1")
                .contentType("application/json")
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void accountBalance() throws Exception {
        //http://localhost:8081/bank2/accountBalance?accountNr=EE123
        mockMvc.perform(MockMvcRequestBuilders.get("/bank2/accountBalance?accountNr=EE123")
                .contentType("application/json")
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void depositMoney() throws Exception {
        //http://localhost:8081/bank2/depositMoney?accountNr=EE123&amount=12
        mockMvc.perform(MockMvcRequestBuilders.get("/bank2/depositMoney?accountNr=EE123&amount=12")
                .contentType("application/json")
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void withdrawMoney() throws Exception {
        //http://localhost:8081/bank2/withdrawMoney?accountNr=EE555&amount=12
        mockMvc.perform(MockMvcRequestBuilders.get("/bank2/withdrawMoney?accountNr=EE123&amount=12")
                .contentType("application/json")
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void transferMoney() throws Exception {
        //http:localhost:8081/bank2/transferMoney?fromAccount=EE123&toAccount=EE124&amount=12
        mockMvc.perform(MockMvcRequestBuilders.get("/bank2/transferMoney?fromAccount=EE123&toAccount=EE124&amount=12")
                .contentType("application/json")
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }
}