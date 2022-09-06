Richardson Maturity Model Level-1: Resource-Based Address
- multiple endpoints
- single verbs

Examples:
    CREATE : POST /api/users/create
    READ   :   GET /api/user/read
    UPDATE : POST /api/users/update
    DELETE : POST /api/users/delete
    SEARCH : GET or POST /api/users?sort=name

Avoid that!
URIs do nor carry info about the operation!
