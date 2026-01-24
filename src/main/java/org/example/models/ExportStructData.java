package org.example.models;

import com.google.gson.annotations.SerializedName;
import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "studentList", "universityList", "statisticalList", "processedAt" })
public class ExportStructData {

    @SerializedName("studentsInfo")
    @XmlElementWrapper(name = "studentsInfo") // Имя внешней обертки
    @XmlElement(name = "studentEntry")
    private List<Student> studentList;

    @SerializedName("universitiesInfo")
    @XmlElementWrapper(name = "universitiesInfo") // Имя внешней обертки
    @XmlElement(name = "universityEntry")
    private List<University> universityList;

    @SerializedName("statisticalInfo")
    @XmlElementWrapper(name = "statisticalInfo") // Имя внешней обертки
    @XmlElement(name = "statisticsEntry")
    private List<Statistics> statisticalList;

    @SerializedName("processedAt")
    @XmlElement(name = "processedAt")
    private String processedAt;

}
