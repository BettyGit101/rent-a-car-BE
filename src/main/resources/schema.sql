CREATE TABLE IF NOT EXISTS CARS (
    ID bigint identity primary key,
    MODEL varchar(255),
    NUM_OF_SEATS bigint,
    NUM_OF_DOORS bigint,
    FUEL_CAPACITY bigint,
    IS_AIR_CONDITION BIT,
    IS_AVAILABLE  BIT
);