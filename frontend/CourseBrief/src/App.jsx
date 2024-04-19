import React from "react";
import "./App.css"; 
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
const SignInSignUpSection = () => {
  return (
    <section style={{ background: '#ffffff', color: 'rgb(255,255,255)' }}>
      <Container className="my-5 py-5" style={{ background: '#f6f6f2', borderRadius: "20px",boxShadow: '0px 0px 20px 0px #9acdd0' }}>
        <Row className="d-flex justify-content-center">
          <Col className="d-flex flex-column">
            <Col 
              className="d-flex flex-fill justify-content-center align-self-center my-5"
              style={{
                background: 'transparent',
                height: '12%',
                
                width: '60%'
              }}
            >
              <Button
                className="btn-primary flex-fill btn-hover"
                type="button"
                style={{
                  background: '#6FB3B8',
                  borderTopRightRadius: '0',
                  borderBottomRightRadius: '0',
                  borderTopLeftRadius: '19px',
                  borderBottomLeftRadius: '19px',
                  fontWeight: 'bold',
                  fontSize: '1.2rem',
                  borderWidth: '0',
                  borderStyle: 'solid',
                  
                }}
              >
                Sign In
              </Button>
              <Button
                className="btn-primary flex-fill btn-hover"
                type="button"
                style={{
                  background: '#A3A3A3',
                  borderTopRightRadius: '19px',
                  borderBottomRightRadius: '19px',
                  borderTopLeftRadius: '0',
                  borderBottomLeftRadius: '0',
                  fontWeight: 'bold',
                  fontSize: '1.2rem',
                  borderWidth: '0',
                 

                }}
              >
                Sign Up
              </Button>
            </Col>
            <div
              className="d-flex justify-content-center align-items-center align-self-center m-5"
              style={{
                height: '422px',
                background: '#ffffff',
                color: 'var(--bs-secondary)',
                width: '552px',
                
                borderWidth: '5px',
                borderRadius: '23px',
                boxShadow: '0px 0px 20px 0px #9acdd0'
              }}
            >
              <Col md={5} xl={6} className="text-center text-md-start">
                <Form method="post" data-bs-theme="light">
                  <Form.Group className="mb-4">
                    <Form.Control
                      type="email"
                      name="email"
                      placeholder="Email"
                      className="shadow"
                    />
                  </Form.Group>
                  <Form.Group className="mb-4">
                    <Form.Control
                      type="password"
                      name="password"
                      placeholder="Password"
                      className="shadow"
                    />
                  </Form.Group>
                  <div className="d-flex justify-content-center mb-4">
                    <Button
                      type="submit"
                      className="btn-primary shadow"
                      style={{ borderRadius: '11px', width: '329.3125px', background: '#6FB3B8' }}
                    >
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

export default SignInSignUpSection;