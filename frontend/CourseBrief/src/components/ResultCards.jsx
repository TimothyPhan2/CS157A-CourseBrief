import React from "react";
import { Badge, Button, Container } from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";
import "../App.css";
import { useNavigate } from "react-router-dom";


const ResultCards = ({ prof, course, tags, courseId }) => {
  const navigate = useNavigate();
  return (
    <Container className="card-style py-2">
      <div className="d-flex justify-content-between">
        <div>
          <div className="d-flex align-items-start prof-title">Professor:</div>
          <div className="prof-name">{prof}</div>
        </div>
        <div>
          <div className="course-title">Course:</div>
          <div className="course-name">{course}</div>
        </div>
      </div>

      {/* <div className="d-flex align-items-start mt-3 tags-title">Tags:</div>
      <div className="d-flex flex-wrap">
        {tags.map((tag, index) => (
          <Badge key={index} pill className="resultTags">
            {tag}
          </Badge>
        ))}
      </div> */}
      <div className="d-flex justify-content-end ">
        <Button className="result-card-btn">Star</Button>
      </div>
      <div className="d-flex justify-content-end my-3">
        <Button className="result-card-btn"  onClick={() => navigate(`/course/${courseId}`)}>View</Button>
      </div>
    </Container>
  );
};

export default ResultCards;
