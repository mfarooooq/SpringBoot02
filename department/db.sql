-- Database: department_db

-- DROP DATABASE IF EXISTS department_db;

CREATE DATABASE department_db
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_United States.1252'
    LC_CTYPE = 'English_United States.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;
-- Table: public.departments

-- DROP TABLE IF EXISTS public.departments;

CREATE TABLE IF NOT EXISTS public.departments
(
    id bigint NOT NULL DEFAULT nextval('departments_id_seq'::regclass),
    department_code character varying(255) COLLATE pg_catalog."default",
    department_description character varying(255) COLLATE pg_catalog."default",
    department_name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT departments_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.departments
    OWNER to postgres;

---------------------------------	
	
-- Database: employee_db

-- DROP DATABASE IF EXISTS employee_db;

CREATE DATABASE employee_db
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_United States.1252'
    LC_CTYPE = 'English_United States.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

-- Table: public.employees

-- DROP TABLE IF EXISTS public.employees;

CREATE TABLE IF NOT EXISTS public.employees
(
    id bigint NOT NULL DEFAULT nextval('employees_id_seq'::regclass),
    department_code character varying(255) COLLATE pg_catalog."default",
    email character varying(255) COLLATE pg_catalog."default" NOT NULL,
    first_name character varying(255) COLLATE pg_catalog."default",
    last_name character varying(255) COLLATE pg_catalog."default",
    organization_code character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT employees_pkey PRIMARY KEY (id),
    CONSTRAINT uk_j9xgmd0ya5jmus09o0b8pqrpb UNIQUE (email)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.employees
    OWNER to postgres;

	