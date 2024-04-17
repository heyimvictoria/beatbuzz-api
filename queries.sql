-- Stored information on Users
CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(30) NOT NULL,
    email VARCHAR(50) NOT NULL,
    password_hash VARCHAR(30) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Stored information on album reviews
CREATE TABLE post (
    review_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    album_name VARCHAR(255) NOT NULL,
    review_text TEXT,
    rating INT,
    review_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

--Sample User
INSERT INTO users (id, pw_hash, username)
VALUES
    ('4', '123s23', 'Tests');

-- Sample Data
-- Insert sample data into the Post table
INSERT INTO post (content, star_rating, user_id, album_name)
VALUES
    ('Great album, must listen!', 5, 1, 'LP4'),


