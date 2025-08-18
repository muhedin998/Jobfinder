@echo off
REM JobFinder Mock Data Loader Script for Windows - PostgreSQL
REM This script loads mock data into your JobFinder PostgreSQL database

setlocal EnableDelayedExpansion

REM Configuration (you can modify these)
if "%DB_HOST%"=="" set DB_HOST=localhost
if "%DB_PORT%"=="" set DB_PORT=5432
if "%DB_NAME%"=="" set DB_NAME=jobfinder
if "%DB_USER%"=="" set DB_USER=dev
if "%DB_PASSWORD%"=="" set DB_PASSWORD=root

REM Set PostgreSQL password environment variable
set PGPASSWORD=%DB_PASSWORD%

echo JobFinder Mock Data Loader (PostgreSQL)
echo ======================================

REM Check if psql client is available
psql --version >nul 2>&1
if errorlevel 1 (
    echo Error: PostgreSQL client (psql) not found. Please install PostgreSQL client.
    exit /b 1
)

REM Get script directory and project root
set SCRIPT_DIR=%~dp0
set PROJECT_ROOT=%SCRIPT_DIR%..

REM Check if migration file exists
set MIGRATION_FILE=%PROJECT_ROOT%\src\main\resources\db\migration\V001__insert_mock_data.sql
if not exist "%MIGRATION_FILE%" (
    echo Error: Migration file not found at %MIGRATION_FILE%
    echo Please run this script from the project root directory or scripts directory
    exit /b 1
)

echo Configuration:
echo   Host: %DB_HOST%
echo   Port: %DB_PORT%
echo   Database: %DB_NAME%
echo   User: %DB_USER%
echo.

REM Test database connection
echo Testing database connection...
psql -h %DB_HOST% -p %DB_PORT% -U %DB_USER% -d %DB_NAME% -c "SELECT 1;" >nul 2>&1
if errorlevel 1 (
    echo Database connection failed
    echo Please check your database configuration and ensure the database is running.
    echo Make sure PostgreSQL is installed and the database '%DB_NAME%' exists.
    exit /b 1
)
echo Database connection successful

REM Prompt for confirmation
echo.
echo Warning: This will insert mock data into your database.
echo Make sure you're not running this on a production database!
echo.
set /p confirm=Continue? (y/N): 
if /i not "%confirm%"=="y" (
    echo Operation cancelled.
    exit /b 0
)

REM Execute the migration
echo Loading mock data...
psql -h %DB_HOST% -p %DB_PORT% -U %DB_USER% -d %DB_NAME% -f "%MIGRATION_FILE%"
if errorlevel 1 (
    echo Failed to load mock data
    echo Check the error messages above for details.
    echo Common issues:
    echo   - Tables don't exist ^(run your Spring Boot app first to create them^)
    echo   - Database connection issues
    echo   - Insufficient privileges
    exit /b 1
)

echo Mock data loaded successfully!
echo.
echo Mock Users Created:
echo   Regular User:
echo     Username: johndoe
echo     Email: john.doe@email.com
echo     Password: password123
echo.
echo   Admin User:
echo     Username: admin
echo     Email: admin@jobfinder.com
echo     Password: password123
echo.
echo Sample Data Includes:
echo   • 8 Job categories
echo   • 24 Skills
echo   • 5 Companies
echo   • 8 Job postings
echo   • Job applications
echo   • Saved jobs
echo   • User profiles and experience
echo   • Notifications
echo   • Company reviews
echo.
echo You can now test your JobFinder application!
echo.
echo Quick verification queries:
echo psql -h %DB_HOST% -p %DB_PORT% -U %DB_USER% -d %DB_NAME% -c "SELECT username, role FROM app_user;"
echo psql -h %DB_HOST% -p %DB_PORT% -U %DB_USER% -d %DB_NAME% -c "SELECT title, company_name FROM job WHERE status = 'ACTIVE';"

pause