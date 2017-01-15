package by.bsuir.ceres.service.impl;

import by.bsuir.ceres.bean.statement.CourseWorkStatement;
import by.bsuir.ceres.bean.statement.DiplomaStatement;
import by.bsuir.ceres.service.DocumentGeneratorService;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;

@Service
public class PdfDocumentGeneratorServiceImpl implements DocumentGeneratorService {


    private static BaseFont baseFont;

    private static Font timesNewRomanFont;

    static {
        try {
            baseFont = BaseFont.createFont("C:\\Windows\\Fonts\\times.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            timesNewRomanFont = new Font(baseFont, 14, Font.NORMAL);
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void generateCourseWorkStatement(CourseWorkStatement courseWorkStatement, OutputStream outputStream) throws DocumentException {
        Document document = new Document(PageSize.A4, 80, 50, 50, 50);
        PdfWriter writer = PdfWriter.getInstance(document, outputStream);
        document.open();
        Paragraph title = new Paragraph("Учреждение образования \t\t\t\t          \n" +
                "«Белорусский государственный университет информатики и радиоэлектроники»\n", timesNewRomanFont);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);

        document.add(Chunk.NEWLINE);

        Paragraph faculty = new Paragraph("Факультет компьютерных систем и сетей", timesNewRomanFont);
        faculty.setAlignment(Element.ALIGN_CENTER);
        document.add(faculty);

        document.add(Chunk.NEWLINE);

        Paragraph headPart = new Paragraph("УТВЕРЖДАЮ\n" +
                "Заведующий кафедрой ПОИТ \n" +
                "_________________________\n" +
                "                (подпись)\n" +
                "___________________" + Calendar.getInstance().get(Calendar.YEAR) + " г.\n", timesNewRomanFont);

        headPart.setAlignment(Element.ALIGN_RIGHT);
        document.add(headPart);

        document.add(Chunk.NEWLINE);

        Paragraph task = new Paragraph("ЗАДАНИЕ\n" +
                "по курсовому проектированию\n", timesNewRomanFont);
        task.setAlignment(Element.ALIGN_CENTER);
        document.add(task);

        document.add(Chunk.NEWLINE);

        Chunk studentField = new Chunk("\tСтуденту ", new Font(baseFont, 14, Font.NORMAL));
        Chunk studentName = new Chunk(courseWorkStatement.getName(), timesNewRomanFont);
        studentName.setUnderline(0.1f, -2f);
        document.add(studentField);
        document.add(studentName);

        document.add(Chunk.NEWLINE);
        document.add(Chunk.NEWLINE);

        Chunk topic = new Chunk("1. Тема работы ", timesNewRomanFont);
        Chunk topicData = new Chunk(courseWorkStatement.getTopic(), timesNewRomanFont);
        topicData.setUnderline(0.1f, -2f);
        document.add(topic);
        document.add(topicData);

        document.add(Chunk.NEWLINE);

        Chunk endDateField = new Chunk("2. Срок сдачи студентом законченной работы ", timesNewRomanFont);
        Chunk endDate = new Chunk(courseWorkStatement.getEndDate(), timesNewRomanFont);
        endDate.setUnderline(0.1f, -2f);
        document.add(endDateField);
        document.add(endDate);

        document.add(Chunk.NEWLINE);

        Chunk inputDataField = new Chunk("3. Исходные данные к работе ", timesNewRomanFont);
        Chunk inputData = new Chunk(courseWorkStatement.getInputDataForWork() != null ? courseWorkStatement.getInputDataForWork() : "", timesNewRomanFont);
        inputData.setUnderline(0.1f, -2f);
        document.add(inputDataField);
        document.add(inputData);

        document.add(Chunk.NEWLINE);

        Chunk contentField = new Chunk("4. Содержание расчётно-пояснительной записки (перечень вопросов, которые подлежат разработке)\n", timesNewRomanFont);
        Chunk content = new Chunk(courseWorkStatement.getContent(), timesNewRomanFont);
        content.setUnderline(0.1f, -2f);
        document.add(contentField);
        document.add(content);

        document.add(Chunk.NEWLINE);

        Chunk graphicField = new Chunk("5. Перечень графического материала (с точным обозначением обязательных чертежей и графиков)\n", timesNewRomanFont);
        Chunk graphic = new Chunk(courseWorkStatement.getGraphic(), timesNewRomanFont);
        graphic.setUnderline(0.1f, -2f);
        document.add(graphicField);
        document.add(graphic);

        document.add(Chunk.NEWLINE);

        Chunk assistantField = new Chunk("6. Консультант по курсовой работе ", timesNewRomanFont);
        Chunk assistant = new Chunk(courseWorkStatement.getAssistant(), timesNewRomanFont);
        assistant.setUnderline(0.1f, -2f);
        document.add(assistantField);
        document.add(assistant);

        document.add(Chunk.NEWLINE);

        Chunk startDateField = new Chunk("7. Дата выдачи задания ", timesNewRomanFont);
        Chunk startDate = new Chunk(courseWorkStatement.getGettingDate(), timesNewRomanFont);
        startDate.setUnderline(0.1f, -2f);
        document.add(startDateField);
        document.add(startDate);

        document.add(Chunk.NEWLINE);
        document.add(Chunk.NEWLINE);

        Chunk scheduleField = new Chunk("8. Календарный график работы над проектом на весь " +
                "период проектирования (с обозначением сроков выполнения и процентом от общего объёма работы):\n", timesNewRomanFont);
        Chunk schedule = new Chunk(courseWorkStatement.getSchedule(), timesNewRomanFont);
        schedule.setUnderline(0.1f, -2f);
        document.add(scheduleField);
        document.add(schedule);

        document.add(Chunk.NEWLINE);
        document.add(Chunk.NEWLINE);

        Chunk assistField2 = new Chunk("РУКОВОДИТЕЛЬ ", timesNewRomanFont);
        Chunk assist = new Chunk("                   " + courseWorkStatement.getAssistant() + "  \n", timesNewRomanFont);
        assist.setUnderline(0.1f, -2f);
        Chunk signature = new Chunk("(подпись)", new Font(baseFont, 9, Font.NORMAL));
        Phrase phrase = new Phrase();
        phrase.add(assistField2);
        phrase.add(assist);
        phrase.add(signature);
        Paragraph assistantPart = new Paragraph();
        assistantPart.add(phrase);
        assistantPart.setAlignment(Element.ALIGN_RIGHT);
        document.add(assistantPart);

        document.add(Chunk.NEWLINE);

        Chunk acceptWorkField = new Chunk("Задание принял к исполнению ", timesNewRomanFont);
        Chunk acceptWork = new Chunk("                                                                               ",
                timesNewRomanFont);
        acceptWork.setUnderline(0.1f, -2f);
        document.add(acceptWorkField);
        document.add(acceptWork);

        document.add(Chunk.NEWLINE);

        Paragraph dateAndSignature = new Paragraph("(дата и подпись студента)", new Font(baseFont, 9, Font.NORMAL));
        dateAndSignature.setAlignment(Element.ALIGN_RIGHT);
        document.add(dateAndSignature);

        document.close();
    }

    @Override
    public void generateDiplomaStatement(DiplomaStatement diplomaStatement, OutputStream outputStream) {

    }
}
