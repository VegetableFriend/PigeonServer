package org.vf.log;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class DBLog {
    final Logger logger = LoggerFactory.getLogger(getClass());

    @Before("execution(* org.vf.business.file.FileController.filePreCreate(..))")
    public void logForFilePrecreate() {
        logger.info("预创建接口调用了");
    }
}
