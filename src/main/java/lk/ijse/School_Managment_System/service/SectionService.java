package lk.ijse.School_Managment_System.service;

import lk.ijse.School_Managment_System.dto.SectionDTO;

public interface SectionService {
    void saveSection(SectionDTO  sectionDTO);
    void updateSection(SectionDTO  sectionDTO);
}
