## API description:

### /auth/: (to do sign in, sign up action)
    1. register-user: register new user
    2. login: login 

### /student/: to contact to student
    1. room/{id}: to get all student by room id
    2. create: create a new student 
    3. room/remove/{roomId}/{studentId}: remove student from room
    4. remove/{id}: remove student from db

### /room/: to contact to room
    1. create: create new room
    2. delete/{id}: remove room from db
    3. /: get all room
### /user/: to contact to user(teacher)
    1. all: get all user
    2.{email}: get user by email
    3. delete/{userId}: remove user from db
### /role/: to contact to role
    ...