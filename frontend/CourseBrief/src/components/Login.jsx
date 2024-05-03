import React from "react";

import {
  Container,
  Navbar,
  Nav,
  Button,
  Form,
  Row,
  Col,
  FormControl,
} from "react-bootstrap";
import 'bootstrap/dist/css/bootstrap.min.css';
import { useNavigate } from 'react-router-dom';
import "../App.css"; 
const LoginPage = () => {
    const navigate = useNavigate();
    
  return (
    <section className="section-style">
      <Container className="container-style  py-5">
        <Row className="d-flex justify-content-center">
          <Col className="d-flex flex-column">
            <Col 
              className="d-flex flex-fill justify-content-center align-self-center my-5"
              style={{ height: '12%', width: '60%' }}
            >
              <Button className="btn-primary flex-fill btn-hover button-signin" type="button">
                Sign In
              </Button>
              <Button className="btn-primary flex-fill btn-hover button-signup" type="button" onClick={() => navigate('/signup')}>
                Sign Up
              </Button>
            </Col>
            <div className="d-flex justify-content-center align-items-center align-self-center m-5 form-container">
              <Col md={5} xl={6} className="text-center text-md-start">
                <Form method="post" data-bs-theme="light">
                  <Form.Group className="mb-4">
                    <FormControl type="email" name="email" placeholder="Email" className="shadow" />
                  </Form.Group>
                  <Form.Group className="mb-4">
                    <FormControl type="password" name="password" placeholder="Password" className="shadow" />
                  </Form.Group>
                  <div className="d-flex justify-content-center mb-4">
                    <Button type="submit" className="btn-primary shadow button-login">
                      Log in
                    </Button>
                  </div>
                </Form>
                <p className="text-muted d-flex justify-content-center">
                  <a href="forgotten-password.html">Forgot your password?</a>
                </p>
              </Col>
            </div>
          </Col>
        </Row>
      </Container>
    </section>
  );
};

export default LoginPage;