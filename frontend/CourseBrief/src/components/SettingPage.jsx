import React, {useContext} from "react";
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
import { AuthContext } from "../userAuth/AuthContext";
import "bootstrap/dist/css/bootstrap.min.css";
import { useNavigate } from "react-router-dom";
import "../App.css";

const SettingPage = () => {
    const { logout } = useContext(AuthContext);
    const navigate = useNavigate();
        const handleLogout = () => {
        logout();
        localStorage.removeItem("user");
        navigate("/login");
        }

  return (
    <section className="section-style">
      <Container className="container-style py-5">
        <Row className="d-flex justify-content-center">
          <Col className="d-flex flex-column">
            <Col
              className="d-flex flex-fill justify-content-center align-self-center my-5"
              style={{ height: "12%", width: "60%" }}
            >
              <h1 className="display-4 text-center fw-bold searchtitle">
                Setting
              </h1>
            </Col>
            <div className="d-flex justify-content-center align-items-center align-self-center m-5 form-container">
              <Col>
                <div>
                  <Col >
                    <div className="d-flex justify-content-center mb-4">
                      <Button className="btn-warning btn-lg shadow button-login" onClick={handleLogout}>
                        Log Out
                      </Button>
                    </div>
                    <div className="d-flex justify-content-center mb-4">
                      <Button className="btn-danger btn-lg shadow button-login" onClick={handleLogout}>
                        Delete Account
                      </Button>
                    </div>
                  </Col>
                </div>
              </Col>
            </div>
          </Col>
        </Row>
      </Container>
    </section>
  );
};

export default SettingPage;
