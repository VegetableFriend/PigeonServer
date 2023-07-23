package org.vf.business.download;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.net.MalformedURLException;

@RestController
public class DownloadController {

    @RequestMapping(value = "/download", method = RequestMethod.POST)
    public Resource processUpload(@RequestPart("filepath") String filePath) {
        File destFile = new File(filePath);

        try {
            return new UrlResource(destFile.toURI());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
