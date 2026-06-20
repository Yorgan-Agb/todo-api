# Todo API

REST API for managing tasks, built with Java and Spring Boot.

## Stack

- Java 21
- Spring Boot 3.5.15
- Maven
- In-memory storage (`ArrayList`)

## Requirements

- JDK 21
- Maven (or use the included Maven Wrapper)

## Running the project

From the project root:

```bash
./mvnw spring-boot:run
```

The server starts on `http://localhost:8080`.

## Endpoints

| Method | Path           | Description              | Success status |
|--------|----------------|--------------------------|----------------|
| GET    | `/tasks`       | List all tasks           | 200            |
| GET    | `/tasks/{id}`  | Get a task by id         | 200            |
| POST   | `/tasks`       | Create a new task        | 201            |
| PUT    | `/tasks/{id}`  | Update an existing task  | 200            |
| DELETE | `/tasks/{id}`  | Delete a task by id      | 204            |

### Task model

```json
{
  "id": 1,
  "title": "Learn Spring Boot",
  "done": false
}
```

The `id` is assigned by the server. The client must not send it when creating a task.

### Example requests

Create a task:

```bash
curl -X POST http://localhost:8080/tasks \
  -H "Content-Type: application/json" \
  -d '{"title": "Learn Spring Boot"}'
```

Update a task:

```bash
curl -X PUT http://localhost:8080/tasks/1 \
  -H "Content-Type: application/json" \
  -d '{"title": "Learn Spring Boot", "done": true}'
```

## Error handling

| Code | Cause                                       |
|------|---------------------------------------------|
| 400  | Invalid request body                        |
| 404  | Task not found (raised by `TaskNotFoundException`) |

## Notes

Tasks are stored in memory and are lost on server restart.
