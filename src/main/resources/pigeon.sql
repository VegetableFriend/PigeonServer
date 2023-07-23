CREATE TABLE IF NOT EXISTS users(uid INT AUTO_INCREMENT PRIMARY KEY,
                                 account VARCHAR(20),
                                 password VARCHAR(20));

CREATE TABLE IF NOT EXISTS file_slices(file_slice_id INT AUTO_INCREMENT PRIMARY KEY,
                                       fid INT,
                                       file_slice_md5 VARCHAR(20),
                                       file_slice_status INT);

CREATE TABLE IF NOT EXISTS files(fid INT AUTO_INCREMENT PRIMARY KEY,
                                 file_md5 VARCHAR(20), 
                                 file_first_128bytes_md5 VARCHAR(20),
                                 file_status INT,
                                 filename VARCHAR(20),
                                 filesize INT);

CREATE TABLE IF NOT EXISTS user_files(releation_id INT AUTO_INCREMENT PRIMARY KEY,
                                      uid INT,
                                      fid INT);

CREATE TABLE IF NOT EXISTS equities(equity_id INT AUTO_INCREMENT PRIMARY KEY,
                                    equity_name VARCHAR(20),
                                    equity_type INT,
                                    equity_price INT,
                                    equity_remain_count INT);

CREATE TABLE IF NOT EXISTS user_equities(releation_id INT AUTO_INCREMENT PRIMARY KEY,
                                         uid INT,
                                         equity_id INT);
-- VERSION 1.0.beta --

ALTER TABLE users CHANGE password password varchar(60);