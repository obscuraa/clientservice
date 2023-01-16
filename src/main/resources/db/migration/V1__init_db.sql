create table if not exists clients (
    id uuid primary key not null default uuid_generate_v4(),
    full_name text,
    email text,
    age int
)

create table if not exists shoes (
    id uuid primary key not null default uuid_generate_v4(),
    name text,
    s_type shoes_type,
    client_id uuid foreign key
)