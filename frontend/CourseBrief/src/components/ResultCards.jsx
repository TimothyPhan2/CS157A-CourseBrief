import React, {useState, useContext} from "react";
import { Card, Badge, Button, Modal } from 'react-bootstrap';
import "bootstrap/dist/css/bootstrap.min.css";
import "../App.css";
import { redirect, useNavigate } from "react-router-dom";
import { AuthContext } from "../userAuth/AuthContext";
import axois1 from "../api/axios";

const ResultCards = ({ prof, course, tags, courseId }) => {
  const { user } = useContext(AuthContext);
  const [showModal, setShowModal] = useState(false);
  
  const handleClose = () => setShowModal(false);
  const handleShow = () => setShowModal(true);
  const navigate = useNavigate();
  
  const starredCourse = {
    
    user: user,
    course: {courseId: courseId}
  };
  
 
  const handleStar = (userName) => {
    axois1.post('starredCourses', starredCourse)
    .then((res) => {
      
      console.log(res.data);
      redirect("/homepage");
    })
    .catch((err) => {
      console.log("starred course", courseId),
      console.log("starred user", userName)
      console.log(err);
    });

  }

  return (
    <>
      <Card className="card-style py-2">
        <Card.Body>
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

          <div className="d-flex align-items-start my-2 tags-title">Tags:</div>
          <div className="d-flex flex-wrap">
            {tags.map((tag, index) => (
              <Badge key={index} pill className="resultTags">
                {tag}
              </Badge>
            ))}
          </div>
          <div className = "d-flex justify-content-end mt-auto">
            <div >
              <Button className="result-card-btn" onClick={() => navigate(`/course/${courseId}`)}>Go to</Button>
            </div>
            <div>
              <Button className="result-card-btn" onClick={handleShow}>View</Button>
            </div>
          </div>
        </Card.Body>
      </Card>

      <Modal show={showModal} onHide={handleClose} size="lg">
        <Modal.Header closeButton>
          <Modal.Title>{prof} - {course}</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <h5>Tags:</h5>
          <div style={{ maxHeight: '200px', overflowY: 'auto' }}>
            {tags.join(', ')}
          </div>
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={handleClose}>
            Close
          </Button>
        </Modal.Footer>
      </Modal>
    </>
  );
};

export default ResultCards;