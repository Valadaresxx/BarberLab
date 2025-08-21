CREATE TABLE barber_services (
    barber_id BIGSERIAL NOT NULL,
    service_id BIGSERIAL NOT NULL,
    PRIMARY KEY (barber_id, service_id),
    CONSTRAINT fk_barber_id FOREIGN KEY (barber_id) REFERENCES barbers (id) ON DELETE CASCADE,
    CONSTRAINT fk_service_id FOREIGN KEY (service_id) REFERENCES services (id) ON DELETE CASCADE
);