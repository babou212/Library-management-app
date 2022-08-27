import React from "react";
import { Link, useMatch, useResolvedPath } from "react-router-dom";

export default function navBar() {

    return (
    <nav className="nav">
        <Link to="/" className="site-title">
            Library Management App
        </Link>
        <ul>
            <CustomLink to="/">Home</CustomLink>
            <CustomLink to="/users">Users</CustomLink>
            <CustomLink to="/items">Items</CustomLink>
            <CustomLink to="/loans">Loans</CustomLink>
        </ul>
    </nav>
    )
}

function CustomLink({ to, children, ...props }) {
    const resolvedPath = useResolvedPath(to)
    const isActive = useMatch({ path: resolvedPath.pathname, end: true })

    return (
        <li className={isActive ? "active" : ""}>
            <Link to={to} {...props}>
                {children}
            </Link>
        </li>
    )
}
