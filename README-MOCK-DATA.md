# JobFinder Mock Data Setup (PostgreSQL)

This directory contains scripts and SQL files to populate your JobFinder PostgreSQL database with realistic mock data for development and testing purposes.

## 📋 What's Included

### Mock Data Overview
- **2 Users**: 1 regular user + 1 admin user
- **8 Job Categories**: Software Development, Data Science, DevOps, etc.
- **24 Skills**: Java, Python, React, Docker, AWS, etc.
- **5 Companies**: Various tech companies with different sizes
- **8 Job Postings**: Realistic job descriptions with requirements
- **User Data**: Profiles, work experience, education, skills
- **Applications**: Sample job applications
- **Saved Jobs**: Jobs bookmarked by users
- **Notifications**: System and job-related notifications
- **Company Reviews**: User reviews of companies

## 👥 Test Users

### Regular User
- **Username**: `johndoe`
- **Email**: `john.doe@email.com`
- **Password**: `password123`
- **Role**: USER

### Admin User
- **Username**: `admin`
- **Email**: `admin@jobfinder.com`
- **Password**: `password123`
- **Role**: ADMIN

## 🚀 Quick Start

### Prerequisites
- PostgreSQL client installed (`psql`)
- JobFinder database created and tables set up (via Hibernate DDL)
- PostgreSQL connection details

### Option 1: Using the Shell Script (Linux/Mac)
```bash
# Make script executable (if not already)
chmod +x scripts/load-mock-data.sh

# Run the script
./scripts/load-mock-data.sh
```

### Option 2: Using the Batch File (Windows)
```cmd
# Run from the project root directory
scripts\load-mock-data.bat
```

### Option 3: Manual SQL Execution
```bash
# Connect to your PostgreSQL database
psql -h localhost -p 5432 -U dev -d jobfinder

# Execute the migration file
\i src/main/resources/db/migration/V001__insert_mock_data.sql
```

## ⚙️ Configuration

You can customize database connection settings using environment variables:

```bash
export DB_HOST=localhost
export DB_PORT=5432
export DB_NAME=jobfinder
export DB_USER=dev
export DB_PASSWORD=root
export PGPASSWORD=root  # For automatic authentication
```

## 🔍 Verification

After running the script, you can verify the data was loaded correctly:

```sql
-- Check users
SELECT username, email, role FROM app_user;

-- Check job postings
SELECT title, company_name, location FROM job WHERE status = 'ACTIVE';

-- Check applications
SELECT u.username, j.title, a.status 
FROM applications a 
JOIN app_user u ON a.user_id = u.id 
JOIN job j ON a.job_id = j.id;
```

## 🐳 Docker Setup

If you're using Docker with PostgreSQL:

```yaml
# docker-compose.yml
version: '3.8'
services:
  db:
    image: postgres:15
    environment:
      POSTGRES_DB: jobfinder
      POSTGRES_USER: dev
      POSTGRES_PASSWORD: root
    ports:
      - "5432:5432"
    volumes:
      - postgres_data:/var/lib/postgresql/data

volumes:
  postgres_data:
```

## ⚠️ Important Notes

1. **Development Only**: This mock data is for development and testing only
2. **Password Security**: All users use the same test password (`password123`)
3. **Data Reset**: Running the script multiple times may cause duplicate key errors
4. **Production Warning**: Never run this on a production database
5. **Sequences**: The script includes sequence resets to maintain proper ID generation

## 🧹 Clean Up

To remove mock data and start fresh, you can truncate the tables:

```sql
-- Disable foreign key checks temporarily (PostgreSQL uses CASCADE)
TRUNCATE TABLE job_view CASCADE;
TRUNCATE TABLE company_review CASCADE;
TRUNCATE TABLE notifications CASCADE;
TRUNCATE TABLE job_alert CASCADE;
TRUNCATE TABLE saved_job CASCADE;
TRUNCATE TABLE applications CASCADE;
TRUNCATE TABLE education CASCADE;
TRUNCATE TABLE work_experience CASCADE;
TRUNCATE TABLE user_skills CASCADE;
TRUNCATE TABLE job_skills CASCADE;
TRUNCATE TABLE user_profile CASCADE;
TRUNCATE TABLE job CASCADE;
TRUNCATE TABLE company CASCADE;
TRUNCATE TABLE skill CASCADE;
TRUNCATE TABLE job_category CASCADE;
TRUNCATE TABLE app_user CASCADE;

-- Reset all sequences
SELECT setval(pg_get_serial_sequence('app_user', 'id'), 1, false);
SELECT setval(pg_get_serial_sequence('job_category', 'id'), 1, false);
SELECT setval(pg_get_serial_sequence('skill', 'id'), 1, false);
SELECT setval(pg_get_serial_sequence('company', 'id'), 1, false);
SELECT setval(pg_get_serial_sequence('job', 'id'), 1, false);
-- Add other sequence resets as needed
```

## 🐛 Troubleshooting

### Common Issues

1. **Connection Failed**: Check PostgreSQL is running and credentials are correct
2. **Table Doesn't Exist**: Ensure Hibernate has created tables first
3. **Duplicate Key Error**: Data might already exist, clean up first
4. **Permission Denied**: Ensure database user has INSERT privileges
5. **psql not found**: Install PostgreSQL client tools

### PostgreSQL-Specific Issues

1. **Sequence Issues**: The script includes sequence resets, but if you have issues:
   ```sql
   -- Check current sequence values
   SELECT * FROM information_schema.sequences;
   
   -- Reset specific sequence
   SELECT setval('app_user_id_seq', (SELECT MAX(id) FROM app_user));
   ```

2. **Authentication Issues**: 
   - Ensure `pg_hba.conf` allows your connection method
   - Use `PGPASSWORD` environment variable or `.pgpass` file

### Getting Help

If you encounter issues:
1. Check your PostgreSQL connection settings
2. Verify your database is running (`pg_isready`)
3. Ensure database and user exist
4. Check database user permissions
5. Verify tables exist (run Spring Boot app once to create them)

## 📊 Sample Queries

Here are some useful queries to explore the mock data:

```sql
-- Find all active job postings with their skills
SELECT j.title, j.company_name, j.location, string_agg(s.name, ', ') as skills
FROM job j 
LEFT JOIN job_skills js ON j.id = js.job_id
LEFT JOIN skill s ON js.skill_id = s.id
WHERE j.status = 'ACTIVE'
GROUP BY j.id, j.title, j.company_name, j.location;

-- User application history
SELECT u.username, j.title, j.company_name, a.status, a.applied_date
FROM applications a
JOIN app_user u ON a.user_id = u.id
JOIN job j ON a.job_id = j.id
ORDER BY a.applied_date DESC;

-- Jobs by category
SELECT jc.name as category, COUNT(j.id) as job_count
FROM job_category jc
LEFT JOIN job j ON jc.id = j.job_category_id AND j.status = 'ACTIVE'
GROUP BY jc.id, jc.name;

-- Popular skills
SELECT s.name, COUNT(js.job_id) as job_count
FROM skill s
JOIN job_skills js ON s.id = js.skill_id
JOIN job j ON js.job_id = j.id AND j.status = 'ACTIVE'
GROUP BY s.id, s.name
ORDER BY job_count DESC;
```

## 🔧 Application Configuration

Make sure your `application.properties` is configured for PostgreSQL:

```properties
spring.datasource.url=jdbc:postgresql://db:5432/jobfinder
spring.datasource.username=dev
spring.datasource.password=root
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.hibernate.ddl-auto=update
```

Don't forget to add the PostgreSQL dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <scope>runtime</scope>
</dependency>
```