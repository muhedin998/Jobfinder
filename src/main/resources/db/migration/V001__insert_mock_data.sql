-- JobFinder Mock Data Migration Script for PostgreSQL
-- This script inserts sample data for development and testing purposes

-- =====================================================
-- USERS (Password: 'password123' encoded with BCrypt)
-- =====================================================

INSERT INTO app_user (id, username, email, password, full_name, role, date_created)
VALUES 
-- Password: password123 (BCrypt encoded with Spring Security BCryptPasswordEncoder)
(1, 'johndoe', 'john.doe@email.com', '$2a$10$tW0UYF137tGeG9Zk3UKieufacFIbgzt/YyS8PElisf8JMtXZ3nWCS', 'John Doe', 'USER', NOW()),
(2, 'admin', 'admin@jobfinder.com', '$2a$10$tW0UYF137tGeG9Zk3UKieufacFIbgzt/YyS8PElisf8JMtXZ3nWCS', 'Admin User', 'ADMIN', NOW());

-- =====================================================
-- JOB CATEGORIES
-- =====================================================

INSERT INTO job_category (id, category_name)
VALUES 
(1, 'Software Development'),
(2, 'Data Science'),
(3, 'DevOps'),
(4, 'Mobile Development'),
(5, 'Frontend Development'),
(6, 'Backend Development'),
(7, 'Quality Assurance'),
(8, 'Product Management');

-- =====================================================
-- SKILLS
-- =====================================================

INSERT INTO skill (id, skill_name)
VALUES 
(1, 'Java'),
(2, 'Python'),
(3, 'JavaScript'),
(4, 'TypeScript'),
(5, 'Go'),
(6, 'Spring Boot'),
(7, 'React'),
(8, 'Angular'),
(9, 'Node.js'),
(10, 'Django'),
(11, 'PostgreSQL'),
(12, 'Docker'),
(13, 'Kubernetes'),
(14, 'AWS'),
(15, 'Git');

-- =====================================================
-- COMPANIES
-- =====================================================

INSERT INTO company (id, name, description, industry, location, website, company_size, founded_year, created_at, updated_at)
VALUES 
(1, 'TechCorp Solutions', 'Leading software development company specializing in enterprise solutions.', 'Technology', 'San Francisco, CA', 'https://techcorp.com', 'LARGE', 2010, NOW(), NOW()),
(2, 'StartupXYZ', 'Fast-growing startup focused on AI and machine learning solutions.', 'AI', 'New York, NY', 'https://startupxyz.com', 'SMALL', 2020, NOW(), NOW()),
(3, 'Global Innovations Inc', 'International technology company providing software solutions.', 'Technology', 'Austin, TX', 'https://globalinnovations.com', 'LARGE', 2005, NOW(), NOW()),
(4, 'DevTools Co', 'Company focused on creating developer tools and productivity software.', 'Developer Tools', 'Seattle, WA', 'https://devtools.co', 'MEDIUM', 2015, NOW(), NOW());

-- =====================================================
-- USER PROFILES
-- =====================================================

INSERT INTO user_profile (id, user_id, bio, summary, city, country, address, phone, linkedin_url, github_url, website, current_job_title, years_of_experience, expected_salary, available_for_work, created_at, updated_at)
VALUES 
(1, 1, 'Passionate software developer with 3 years of experience in full-stack development.', 'Full-stack developer specializing in Java and React', 'San Francisco', 'USA', '123 Tech Street, San Francisco, CA', '+1234567890', 'https://linkedin.com/in/johndoe', 'https://github.com/johndoe', 'https://johndoe.dev', 'Software Developer', 3, 95000.0, true, NOW(), NOW());

-- =====================================================
-- JOB POSTINGS
-- =====================================================

INSERT INTO job (id, title, description, requirements, location, job_type, salary, company_name, company_id, experience_level, is_remote, application_deadline, benefits, positions_available, status, date_posted, user_id, category_id, is_draft)
VALUES 
(1, 'Senior Java Developer', 
 'We are looking for an experienced Java developer to join our backend team.',
 'Bachelor degree in CS, 5+ years Java experience, Spring Framework knowledge.',
 'San Francisco, CA', 'FULL_TIME', 95000.00, 'TechCorp Solutions', 1, 'SENIOR_LEVEL', false, 
 NOW() + INTERVAL '30 days', 
 'Health insurance, 401k matching, flexible PTO', 2, 'ACTIVE', NOW(), 2, 1, false),

(2, 'Frontend React Developer', 
 'Join our frontend team to build amazing user interfaces using React.',
 '3+ years React experience, JavaScript/TypeScript proficiency.',
 'New York, NY', 'FULL_TIME', 85000.00, 'StartupXYZ', 2, 'MID_LEVEL', true,
 NOW() + INTERVAL '45 days',
 'Equity package, health insurance, flexible hours', 1, 'ACTIVE', NOW(), 2, 5, false),

(3, 'DevOps Engineer', 
 'We need a DevOps engineer to help us scale our infrastructure.',
 'Docker and Kubernetes experience, AWS/Azure knowledge.',
 'Austin, TX', 'FULL_TIME', 105000.00, 'Global Innovations Inc', 3, 'SENIOR_LEVEL', false,
 NOW() + INTERVAL '60 days',
 'Stock options, comprehensive health coverage', 1, 'ACTIVE', NOW(), 2, 3, false),

(4, 'Junior Python Developer', 
 'Great opportunity for a junior developer to learn and grow.',
 '1-2 years Python experience, Django or Flask knowledge.',
 'Seattle, WA', 'FULL_TIME', 65000.00, 'DevTools Co', 4, 'ENTRY_LEVEL', false,
 NOW() + INTERVAL '21 days',
 'Mentorship program, health insurance, PTO', 2, 'ACTIVE', NOW(), 2, 1, false);

-- =====================================================
-- JOB SKILLS RELATIONSHIP
-- =====================================================

INSERT INTO job_skills (job_id, skill_id) VALUES 
(1, 1), (1, 6), (1, 11), (1, 12), (1, 15),  -- Senior Java Developer
(2, 3), (2, 4), (2, 7), (2, 15),            -- Frontend React Developer  
(3, 12), (3, 13), (3, 14), (3, 15),         -- DevOps Engineer
(4, 2), (4, 10), (4, 11), (4, 15);          -- Junior Python Developer

-- =====================================================
-- USER SKILLS  
-- =====================================================

INSERT INTO user_skills (user_id, skill_id) VALUES
(1, 1), (1, 6), (1, 3), (1, 7), (1, 11), (1, 12), (1, 15);

-- =====================================================
-- WORK EXPERIENCE
-- =====================================================

INSERT INTO work_experience (id, user_profile_id, company_name, job_title, description, start_date, end_date)
VALUES
(1, 1, 'Previous Tech Company', 'Software Developer', 'Developed web applications using Java Spring Boot and React.', '2021-06-01', '2024-01-31'),
(2, 1, 'Startup Inc', 'Junior Developer', 'First professional role learning full-stack development.', '2020-01-15', '2021-05-31');

-- =====================================================
-- EDUCATION
-- =====================================================

INSERT INTO education (id, user_profile_id, institution, degree, field_of_study, start_date, end_date, description)
VALUES
(1, 1, 'University of California, Berkeley', 'Bachelor of Science', 'Computer Science', '2016-08-15', '2020-05-15', 'Studied computer science fundamentals.');

-- =====================================================
-- JOB APPLICATIONS
-- =====================================================

INSERT INTO applications (id, user_id, job_id, cover_letter, application_status, date_applied)
VALUES
(1, 1, 1, 'I am very interested in this Senior Java Developer position.', 0, NOW()),
(2, 1, 2, 'I am very interested in this Frontend React Developer position.', 0, NOW());

-- =====================================================
-- SAVED JOBS
-- =====================================================

INSERT INTO saved_job (id, user_id, job_id, saved_at)
VALUES
(1, 1, 3, NOW()),
(2, 1, 4, NOW());