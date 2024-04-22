import React from "react";
import { Container, Row, Col, Button } from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";
import "../App.css";

import { useNavigate } from "react-router-dom";
const LandingPage = () => {
  const handleSubmit = (event) => {
    event.preventDefault();
    // Add logic to handle the search submission, e.g., making an API call
    console.log("Form submitted!");
  };

  return (
    <header className="pt-5">
      <div className="container pt-4 pt-xl-5">
        <div className="row pt-5">
          <div className="col-md-8 text-center text-md-start mx-auto">
            <div className="text-center">
              <h1 className="display-4 fw-bold mb-5">
                Unlock Your Ideal
                <br />
                <span className="underline">Curriculum</span>.
              </h1>
              <p className="fs-5 text-muted mb-5">
                Explore, Rate, and Tailor Your CS & CMPE Courses at SJSU!
              </p>

              <form
                className="d-flex justify-content-center flex-wrap "
                onSubmit={handleSubmit}
                style={{backgroundColor: '#ffffff'}}
              >
                <div className="shadow-lg mb-3" style={{ width: "70%"}}>
                  <input
                    className="form-control form-control-lg form-css"
                    type="email"
                    name="search"
                    placeholder="search course/prof"
                    style={{ height: "50px" }}
                  />
                </div>
                <div className="shadow-lg mb-3">
                  <button
                    className="btn btn-primary btn-lg search-btn"
                    type="submit"
                    style={{ height: "50px", width: "150px" }}
                  >
                    Search
                  </button>
                </div>
              </form>
            </div>
          </div>
          <div className="col-12 col-lg-10 mx-auto">
            <div className="text-center position-relative">
              {/* Replace this src with the path to your image asset in React project */}
              <img
                className="img-fluid"
                src="path_to_image/Firefly_student_searching_courses_on_a_laptop_30565.jpg"
                style={{ width: "800px" }}
                alt="Student searching courses on laptop"
              />
            </div>
          </div>
        </div>
      </div>
    </header>
  );
};

export default LandingPage;
