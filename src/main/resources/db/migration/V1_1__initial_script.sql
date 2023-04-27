create table public.roles
(
    id         bigserial
        primary key,
    role       varchar(20)           not null
        unique,
    created    timestamp(6)          not null,
    changed    timestamp(6),
    is_deleted boolean default false not null
);

alter table public.roles
    owner to pablito;

create table public.users
(
    id         bigserial
        primary key,
    name       varchar(50)           not null,
    surname    varchar(50)           not null,
    date_birth timestamp(6)          not null,
    created    timestamp(6)          not null,
    change     timestamp(6),
    is_deleted boolean default false not null,
    sex        varchar(15)           not null,
    height     integer default 0     not null,
    role_id    bigint  default 2     not null
        constraint users_roles_id_fk
            references public.roles
);

alter table public.users
    owner to pablito;

create index users_date_birth_index
    on public.users (date_birth desc);

create index users_name_index
    on public.users (name);

create index users_name_surname_index
    on public.users (name, surname);

create index users_surname_index
    on public.users (surname);

create table public.group_trainers
(
    id         bigserial
        primary key,
    user_id    bigint                not null
        unique
        constraint group_trainers_users_id_fk
            references public.users,
    work_zone  varchar(50)           not null,
    created    timestamp(6)          not null,
    changed    timestamp(6),
    is_deleted boolean default false not null
);

alter table public.group_trainers
    owner to pablito;

CREATE SEQUENCE parameter_gym_id_seq AS bigint;
create table public.parameters_gym
(
    id           bigint  default nextval('parameter_gym_id_seq'::regclass) not null
        constraint parameter_gym_pkey
            primary key,
    user_id      bigint                                                    not null
        constraint parameter_gym_users_id_fk
            references public.users,
    weight       real                                                      not null,
    fat_percent  real,
    max_bench    real                                                      not null,
    max_squat    real                                                      not null,
    max_traction real                                                      not null,
    created      timestamp(6)                                              not null,
    chenged      timestamp(6),
    is_deleted   boolean default false                                     not null
);

alter table public.parameters_gym
    owner to pablito;

create table public.target_gym
(
    id              bigserial
        primary key
        unique,
    user_id         bigint                not null
        constraint target_gym_pk
            unique
        constraint target_gym_parameter_gym_id_fk
            references public.users,
    target_weight   real                  not null,
    target_fat_per  real,
    target_bench    real                  not null,
    target_squat    real                  not null,
    target_traction real                  not null,
    created         timestamp(6)          not null,
    is_deleted      boolean default false not null,
    changed         timestamp(6)
);

alter table public.target_gym
    owner to pablito;

create index target_gym_id_index
    on public.target_gym (id);

create index target_gym_param_gym_id_index
    on public.target_gym (user_id);

create table public.contacts
(
    id           bigserial
        primary key,
    user_id      bigint                not null
        constraint contacts_users_id_fk
            references public.users,
    phone_number bigint
        unique,
    email        varchar(255)
        constraint "contacts_Email_key"
            unique,
    city         char(85),
    country      char(25),
    street       char(100),
    house_number integer,
    flat         integer,
    created      timestamp(6)          not null,
    changed      timestamp(6),
    is_deleted   boolean default false not null
);

alter table public.contacts
    owner to pablito;

create index contacts_user_id_index
    on public.contacts (user_id);

create table public.c_exercises
(
    id             bigserial
        primary key,
    "exerciseDESC" text                  not null,
    created        timestamp(6)          not null,
    changed        timestamp(6),
    id_deleted     boolean default false not null,
    name           varchar(50)           not null
        unique
);

alter table public.c_exercises
    owner to pablito;

create table public.c_muscles
(
    id      bigserial
        primary key
        unique,
    muscle  text                  not null,
    created timestamp(6)          not null,
    changed timestamp(6),
    deleted boolean default false not null
);

alter table public.c_muscles
    owner to pablito;

create index c_muscles_id_index
    on public.c_muscles (id);

create table public.exercise_muscles
(
    id          bigserial
        primary key,
    exercise_id bigint                not null
        constraint exercise_muscles_c_exercises_id_fk
            references public.c_exercises
            on update cascade on delete cascade,
    muscle_id   bigint                not null
        constraint exercise_muscles_c_muscles_id_fk
            references public.c_muscles
            on update cascade on delete cascade,
    changed     timestamp(6),
    created     timestamp(6)          not null,
    is_deleted  boolean default false not null
);

alter table public.exercise_muscles
    owner to pablito;

create index exercise_muscles_exercise_id_index
    on public.exercise_muscles (exercise_id);

create table public.programs
(
    id              bigserial
        primary key,
    data_start      timestamp(4)          not null,
    data_end        timestamp(4)          not null,
    program         text                  not null,
    parametr_gym_id bigint                not null
        constraint programs_parameters_gym_id_fk
            references public.parameters_gym,
    target_gym_id   bigint                not null
        constraint programs_target_gym_id_fk
            references public.target_gym,
    is_deleted      boolean default false not null,
    created         timestamp(6)          not null,
    chenged         timestamp(6)
);

alter table public.programs
    owner to pablito;

create index programs_user_id_data_start_index
    on public.programs (data_start desc);

create table public.blocks
(
    id          bigserial
        primary key,
    "blockDESC" text                  not null,
    program_id  bigint                not null
        constraint blocks_programs_id_fk
            references public.programs,
    created     timestamp(6)          not null,
    chenged     timestamp(6),
    is_deleed   boolean default false not null
);

alter table public.blocks
    owner to pablito;

create index blocks_program_id_created_index
    on public.blocks (program_id asc, created desc);

create table public.workouts
(
    id         bigserial
        primary key,
    blok_id    bigint                not null
        constraint workouts_blocks_id_fk
            references public.blocks,
    week       integer               not null,
    day        integer               not null,
    created    timestamp(6)          not null,
    chenged    timestamp(6),
    is_deleted boolean default false not null
);

alter table workouts
    owner to pablito;

create index workouts_blok_id_index
    on workouts (blok_id);

create index workouts_week_day_index
    on workouts (week asc, day desc);


create table public.log_workouts
(
    log_wo_id  bigserial
        primary key,
    workout_id bigint
        constraint log_workouts_workouts_id_fk
            references public.workouts,
    date_wo    timestamp(4)          not null,
    intensity  text                  not null,
    comments   text                  not null,
    created    timestamp(6)          not null,
    chenged    timestamp(6),
    is_deleted boolean default false not null
);

alter table public.log_workouts
    owner to pablito;

create table public.workaout_sets
(
    wo_set_id      bigserial
        primary key,
    workout_id     bigint                                                          not null
        constraint workaout_set_workouts_id_fk
            references workouts,
    exercise_id    bigint                                                          not null
        constraint workaout_set_c_exercises_id_fk
            references c_exercises,
    set            integer                                                         not null,
    reps_max       integer                                                         not null,
    reps_min       integer                                                         not null,
    rpe            integer                                                         not null,
    created        timestamp(6)                                                    not null,
    chenged        timestamp(6),
    is_deleted     boolean default false                                           not null,
    percent_of_max real                                                            not null
);

alter table public.workaout_sets
    owner to pablito;

create index workaout_set_workout_id_index
    on public.workaout_sets (workout_id);



create table public.log_sets
(
    log_set_id bigserial
        primary key,
    wo_set_id  bigint                not null
        constraint log_sets_workaout_set_wo_set_id_fk
            references public.workaout_sets,
    log_wo_id  bigint                not null
        constraint log_sets_log_workouts_log_wo_id_fk
            references public.log_workouts,
    reps_done  integer               not null,
    weit_done  double precision      not null,
    created    timestamp(6)          not null,
    chenged    timestamp(6),
    is_deleted boolean default false not null,
    num_set    integer               not null
);

alter table public.log_sets
    owner to pablito;

create index log_sets_wo_set_id_index
    on public.log_sets (wo_set_id desc);



