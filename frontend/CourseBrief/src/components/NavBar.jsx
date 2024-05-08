import React, {useContext} from "react";
import { Navbar, Nav, Container } from "react-bootstrap";
import { Link, NavLink } from "react-router-dom";
import { AuthContext } from "../userAuth/AuthContext";
const NavBar = () => {
  const { user } = useContext(AuthContext);
  
  
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

            
            {user ? (
              
            <>
              <Nav.Link as={NavLink} to="/homepage" className="nav-item nav-home">
                Home
              </Nav.Link>
              <Nav.Link as={NavLink} to="/search" className="nav-item nav-search">
                Search
              </Nav.Link>
              <Nav.Link as={NavLink} to="/setting" className="nav-item nav-search">
                Setting
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
