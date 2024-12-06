SELECT
    u.username,
    r.role_name AS role_name,
    p.name AS permission_name
FROM
    users u
        INNER JOIN
    user_roles ur ON u.id = ur.user_id
        INNER JOIN
    roles r ON ur.role_id = r.id
        INNER JOIN
    role_permissions rp ON r.id = rp.role_id
        INNER JOIN
    permissions p ON rp.permission_id = p.id;



SELECT
    p.name AS permission_name,
    r.role_name AS role_name
FROM
    permissions p
        INNER JOIN role_permissions pr ON p.id = pr.permission_id
        INNER JOIN roles r ON pr.role_id = r.id;