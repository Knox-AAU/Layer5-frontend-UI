package knox.frontend.controller;

import knox.frontend.model.UserData;
import knox.frontend.model.Search;
import knox.frontend.utility.FileManager;
import knox.frontend.utility.GrundfosConnection;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.*;
@SpringBootApplication
@RequestMapping(value="/getpdf")
@RestController
public class GetpdfController {

    RestTemplate restTemplate = new RestTemplate();
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<byte[]> getPDF(@RequestParam int id) {

        String url = "localhost:8081/api/file?id=" + id;
        ResponseEntity<byte[]> response = this.restTemplate.getForEntity(url, byte[].class);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/pdf"));
        String filename = "pdf" + id + ".pdf";
        headers.add("Content-Disposition", "inline; filename=" + filename);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

        return response;
    }
}
