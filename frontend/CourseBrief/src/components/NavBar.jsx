import React from "react";
import { Navbar, Nav, Container } from "react-bootstrap";
import { Link, NavLink } from "react-router-dom";

const NavBar = ({ isLoggedIn }) => {
  return (
    <Navbar
      bg="dark"
      variant="dark"
      expand="lg"
      fixed="top"
      className="custom-navbar mb-5"
    >
      <Container className="navbar-container">
        <Navbar.Brand as={Link} to="/" className="navbar-brand">
          CourseBrief
        </Navbar.Brand>
        <Navbar.Toggle aria-controls="navbar" className="navbar-toggle" />
        <Navbar.Collapse id="navbar" className="navbar-collapse">
          <Nav className="ms-auto navbar-nav">

            <Nav.Link as={NavLink} to="/" className="nav-item nav-home">
              Home
            </Nav.Link>
            {isLoggedIn ? (
              <>
                <Nav.Link as={NavLink} to="/search" className="nav-item nav-search">
                  Search
                </Nav.Link>
              </>
            ) : (
              <>
              
              <Nav.Link as={NavLink} to="/login" className="nav-item nav-login">
                Login
              </Nav.Link>
              <Nav.Link as={NavLink} to="/signup" className="nav-item nav-signup">
                Signup
              </Nav.Link>
              </>
            )}
            
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
};

export default NavBar;
