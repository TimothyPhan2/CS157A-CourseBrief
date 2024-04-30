import React from 'react';
import { Container, Row, Col, Button } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import '../App.css';

import { useNavigate } from 'react-router-dom';
const LandingPage = () => {
    const navigate = useNavigate();
    return (
        <Container className="landing-page">
            <Row>
                <Col>
                    <h1>Welcome to our Landing Page</h1>
                    <p>Thank you for visiting our website!</p>
                    <Button variant="primary" onClick={() => navigate('login')} >Get Started</Button>
                </Col>
            </Row>
        </Container>
    );
};

export default LandingPage;