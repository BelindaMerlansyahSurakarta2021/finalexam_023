/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pws.finalexam;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Belinda merlansyah_20200140023
 */

@RestController
@ResponseBody
public class personalController {
    
          PersonalJpaController jpapersonal = new PersonalJpaController();
    @GetMapping("/GET")
    public List<Personal> getdata(){
        List<Personal> listpersonal = new ArrayList<>();
        
        listpersonal = jpapersonal.findPersonalEntities();
        return listpersonal;
    }
    
        // Membuat Method  Post mapping data untuk menambahkan data
    @PostMapping("/POST")
    public String sendData(HttpEntity<String> kiriman) throws Exception{
        String json_receive = kiriman.getBody();
        
        ObjectMapper mapper = new ObjectMapper();
        
        // Membuat objek baru untuk finaluas
        Personal data = new Personal();
        
        
        data= mapper.readValue(json_receive, Personal.class);
        jpapersonal.create(data); // memanggil method create pada JPA controller
        
        
        return json_receive;
    }
    
    // Membuat Method PUT mapping untuk edit data
    @PutMapping("/PUT")
    public String editData(HttpEntity<String> kiriman) throws Exception{
        String json_receive = kiriman.getBody();
        
        ObjectMapper mapper = new ObjectMapper();
        Personal data = new Personal();
        
        data= mapper.readValue(json_receive, Personal.class);
        jpapersonal.edit(data); // memanggil method edit pada jpa Controller
        
        
        return json_receive;
    }
    
    // Membuat method Delete mapping data untuk menghapus data pada database
    @DeleteMapping("/DELETE")
    public String deleteData(HttpEntity<String> kiriman) throws Exception{
        String json_receive = kiriman.getBody();
        String message = "no action";
        
        ObjectMapper mapper = new ObjectMapper();
        Personal data = new Personal();
        
        data= mapper.readValue(json_receive, Personal.class);
        jpapersonal.destroy(data.getId()); // memanggil method destroy atau hapus pada jpa Controller
        
        message = "id = " + data.getId().toString() + " Deleted"; // membuat pesan notifikasi untuk pengguna
        
        return message;
    }
}

   
