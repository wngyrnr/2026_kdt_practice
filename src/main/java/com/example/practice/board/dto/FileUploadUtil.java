package com.example.practice.board.dto;

import com.example.practice.board.dto.BoardFileDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Component
public class FileUploadUtil {

    @Value("${file.upload-dir}")
    private String uploadDir;

    public BoardFileDto save(MultipartFile file) {
        if (file == null || file.isEmpty()) {
            return null;
        }

        String originalName = file.getOriginalFilename();

        String ext = "";
        int dotIndex = originalName.lastIndexOf('.');
        if (dotIndex > -1) {
            ext = originalName.substring(dotIndex);
        }

        String saveName = UUID.randomUUID() + ext;

        File dir = new File(uploadDir).getAbsoluteFile();
        if (!dir.exists()) {
            dir.mkdirs(); // 경로가 없으면 생성
        }

        File dest = new File(dir, saveName);

        try {
            file.transferTo(dest); // 실제 로컬 저장
        } catch (IOException e) {
            throw new RuntimeException("파일 저장 실패: " + originalName, e);
        }

        BoardFileDto fileDto = new BoardFileDto();
        fileDto.setFileName(saveName);
        fileDto.setOriginalName(originalName);
        fileDto.setFilePath(dest.getAbsolutePath());
        fileDto.setFileSize(file.getSize());
        fileDto.setFileType(file.getContentType());

        return fileDto; // boardId는 아직 모르므로 비워둠
    }
}