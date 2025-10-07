services:
  db:
    image: postgres:16
    container_name: postgres_container
    restart: always
    environment:
      POSTGRES_USER: admin
      POSTGRES_PASSWORD: admin123
      POSTGRES_DB: closedsarc
    ports:
      - "5432:5432"
    volumes:
      - postgres_data:/var/lib/postgresql/data
  doiscontainers-1:
    depends_on:
        db:
          condition: service_started
    build:
      context: ../admin-service
      dockerfile: Dockerfile
      tags: ["microservicedemo", "doiscontainers-1"]
    ports:
      - 8443:8080
  doiscontainers-2:
    depends_on:
        db:
          condition: service_started
    build:
      context: ../professor-service
      dockerfile: Dockerfile
      tags: ["microservicedemo", "doiscontainers-2"]
    ports:
      - 8444:8080

volumes:
  postgres_data: