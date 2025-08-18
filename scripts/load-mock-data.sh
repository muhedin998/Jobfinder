#!/bin/bash

# JobFinder Mock Data Loader Script for PostgreSQL
# This script loads mock data into your JobFinder PostgreSQL database

set -e  # Exit on any error

# Color codes for output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

# Configuration (you can modify these)
DB_HOST=${DB_HOST:-localhost}
DB_PORT=${DB_PORT:-5432}
DB_NAME=${DB_NAME:-jobfinder}
DB_USER=${DB_USER:-elvedin}

echo -e "${BLUE}JobFinder Mock Data Loader (PostgreSQL)${NC}"
echo "======================================"

# Check if psql client is available
if ! command -v psql &> /dev/null; then
    echo -e "${RED}Error: PostgreSQL client (psql) not found. Please install PostgreSQL client.${NC}"
    exit 1
fi

# Get the script directory and project root
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_ROOT="$(dirname "$SCRIPT_DIR")"

# Check if migration file exists
MIGRATION_FILE="$PROJECT_ROOT/src/main/resources/db/migration/V001__insert_mock_data.sql"
if [ ! -f "$MIGRATION_FILE" ]; then
    echo -e "${RED}Error: Migration file not found at $MIGRATION_FILE${NC}"
    echo "Please run this script from the project root directory or scripts directory"
    exit 1
fi

echo -e "${YELLOW}Configuration:${NC}"
echo "  Host: $DB_HOST"
echo "  Port: $DB_PORT" 
echo "  Database: $DB_NAME"
echo "  User: $DB_USER"
echo ""

# Test database connection
echo -e "${BLUE}Testing database connection...${NC}"
if psql -h "$DB_HOST" -p "$DB_PORT" -U "$DB_USER" -d "$DB_NAME" -c "SELECT 1;" &> /dev/null; then
    echo -e "${GREEN}✓ Database connection successful${NC}"
else
    echo -e "${RED}✗ Database connection failed${NC}"
    echo "Please check your database configuration and ensure the database is running."
    echo "Make sure PostgreSQL is installed and the database '$DB_NAME' exists."
    exit 1
fi

# Prompt for confirmation
echo -e "${YELLOW}Warning: This will insert mock data into your database.${NC}"
echo -e "${YELLOW}Make sure you're not running this on a production database!${NC}"
echo ""
read -p "Continue? (y/N): " -n 1 -r
echo ""

if [[ ! $REPLY =~ ^[Yy]$ ]]; then
    echo "Operation cancelled."
    exit 0
fi

# Execute the migration
echo -e "${BLUE}Loading mock data...${NC}"
if psql -h "$DB_HOST" -p "$DB_PORT" -U "$DB_USER" -d "$DB_NAME" -f "$MIGRATION_FILE"; then
    echo -e "${GREEN}✓ Mock data loaded successfully!${NC}"
    echo ""
    echo -e "${GREEN}Mock Users Created:${NC}"
    echo "  Regular User:"
    echo "    Username: johndoe"
    echo "    Email: john.doe@email.com"
    echo "    Password: password123"
    echo ""
    echo "  Admin User:"
    echo "    Username: admin"
    echo "    Email: admin@jobfinder.com"  
    echo "    Password: password123"
    echo ""
    echo -e "${GREEN}Sample Data Includes:${NC}"
    echo "  • 8 Job categories"
    echo "  • 24 Skills"  
    echo "  • 5 Companies"
    echo "  • 8 Job postings"
    echo "  • Job applications"
    echo "  • Saved jobs"
    echo "  • User profiles and experience"
    echo "  • Notifications"
    echo "  • Company reviews"
    echo ""
    echo -e "${GREEN}You can now test your JobFinder application!${NC}"
    echo ""
    echo -e "${BLUE}Quick verification queries:${NC}"
    echo "psql -h $DB_HOST -p $DB_PORT -U $DB_USER -d $DB_NAME -c \"SELECT username, role FROM app_user;\""
    echo "psql -h $DB_HOST -p $DB_PORT -U $DB_USER -d $DB_NAME -c \"SELECT title, company_name FROM job WHERE status = 'ACTIVE';\""
else
    echo -e "${RED}✗ Failed to load mock data${NC}"
    echo "Check the error messages above for details."
    echo "Common issues:"
    echo "  - Tables don't exist (run your Spring Boot app first to create them)"
    echo "  - Database connection issues"
    echo "  - Insufficient privileges"
    exit 1
fi
