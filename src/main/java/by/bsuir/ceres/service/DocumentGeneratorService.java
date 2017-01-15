package by.bsuir.ceres.service;

import by.bsuir.ceres.bean.statement.CourseWorkStatement;
import by.bsuir.ceres.bean.statement.DiplomaStatement;
import com.itextpdf.text.DocumentException;

import java.io.OutputStream;

public interface DocumentGeneratorService {
    void generateCourseWorkStatement(CourseWorkStatement courseWorkStatement, OutputStream outputStream) throws DocumentException;
    void generateDiplomaStatement(DiplomaStatement diplomaStatement, OutputStream outputStream);
}
