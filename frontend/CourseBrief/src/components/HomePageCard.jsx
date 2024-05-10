import React, { useState } from "react";
import { Card, Button, Modal } from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";
import "../App.css";

const HomePageCard = ({ profName, className, tagList, commentList }) => {
  const [showModal, setShowModal] = useState(false);

  const handleClose = () => setShowModal(false);
  const handleShow = () => setShowModal(true);

  return (
    <>
      <Card className="card-style mb-4 shadow-sm">
        <Card.Body className="p-4 text-center">
          <Card.Title className="mb-2 font-weight-bold">{profName}</Card.Title>
          <Card.Subtitle className="mb-2 text-muted">{className}</Card.Subtitle>
          <Card.Text>
            <strong>Tags:</strong> {tagList.slice(0, 5).join(", ")}
          </Card.Text>
          <Card.Text>
            <strong>Comments:</strong> {commentList[0]}
          </Card.Text>
          <div>
            <Button variant="primary search-btn text-center" onClick={handleShow}>
                View
            </Button>
          </div>
        </Card.Body>
      </Card>

      <Modal show={showModal} onHide={handleClose} size="lg">
        <Modal.Header closeButton>
          <Modal.Title>
            {profName} - {className}
          </Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <h5>Tags:</h5>
          <ul style={{ maxHeight: "200px", overflowY: "auto" }}>
            {tagList.map((tag, index) => (
              <li key={index}>{tag}</li>
            ))}
          </ul>

          <h5 className="mt-4">Comments:</h5>
          <ul style={{ maxHeight: "200px", overflowY: "auto" }}>
            {commentList.map((comment, index) => (
              <li key={index}>{comment}</li>
            ))}
          </ul>
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

export default HomePageCard;
