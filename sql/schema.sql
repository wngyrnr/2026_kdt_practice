-- ============================================
-- board_table : 게시글
-- ============================================
CREATE TABLE board_table (
                             board_id    BIGINT AUTO_INCREMENT PRIMARY KEY,
                             category    VARCHAR(50)  NOT NULL,
                             title       VARCHAR(200) NOT NULL,
                             writer      VARCHAR(50)  NOT NULL,
                             content     TEXT         NOT NULL,
                             created_at  DATETIME     DEFAULT CURRENT_TIMESTAMP,
                             updated_at  DATETIME     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ============================================
-- file_table : 게시글 첨부파일 (board_table과 1:N)
-- ============================================
CREATE TABLE file_table (
                            file_id        BIGINT AUTO_INCREMENT PRIMARY KEY,
                            board_id       BIGINT       NOT NULL,
                            file_name      VARCHAR(255) NOT NULL,
                            original_name  VARCHAR(255) NOT NULL,
                            file_path      VARCHAR(500) NOT NULL,
                            created_at     DATETIME     DEFAULT CURRENT_TIMESTAMP,
                            file_size      BIGINT       NOT NULL,
                            file_type      VARCHAR(100),
                            CONSTRAINT fk_file_board
                                FOREIGN KEY (board_id) REFERENCES board_table(board_id)
                                    ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;