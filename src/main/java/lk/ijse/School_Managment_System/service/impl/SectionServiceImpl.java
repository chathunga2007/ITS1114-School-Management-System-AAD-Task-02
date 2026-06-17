package lk.ijse.School_Managment_System.service.impl;

import lk.ijse.School_Managment_System.dto.SectionDTO;
import lk.ijse.School_Managment_System.entity.Section;
import lk.ijse.School_Managment_System.repository.SectionRepository;
import lk.ijse.School_Managment_System.service.SectionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@Slf4j
public class SectionServiceImpl implements SectionService {
    private final SectionRepository sectionRepository;

    public SectionServiceImpl(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    @Override
    public void saveSection(SectionDTO sectionDTO) {
        log.info("Saving section {}",sectionDTO);
        try {

            Section section = new Section();
            section.setDescription(sectionDTO.getDescription());

            sectionRepository.save(section);

        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public void updateSection(SectionDTO sectionDTO) {
        log.info("Updating section {}",sectionDTO);
        try {

            Optional<Section> optionalSection = sectionRepository.findById(sectionDTO.getSectionId());
            if (optionalSection.isEmpty()) {
                throw new Exception("Section not found with id " + sectionDTO.getSectionId());
            }

            Section section = optionalSection.get();

            section.setDescription(sectionDTO.getDescription());

            sectionRepository.save(section);

        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}