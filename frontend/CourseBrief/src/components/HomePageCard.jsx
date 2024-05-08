import React, { useState } from 'react';
import { Card, Button, Collapse } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import '../App.css';

const HomePageCard = ({ profName, className, tagList, commentList }) => {
    const [openTags, setOpenTags] = useState(false);
    const [openComments, setOpenComments] = useState(false);

    return (
        <Card className="card-style">
            <Card.Body>
                <Card.Title>{profName}</Card.Title>
                <Card.Subtitle className="mb-2 text-muted">{className}</Card.Subtitle>

                {/* Tags Section */}
                <Card.Text>
                    <strong>Tags:</strong> {tagList.slice(0, 5).join(', ')}
                    {tagList.length > 5 && (
                        <>
                            <Button
                                variant="link"
                                onClick={() => setOpenTags(!openTags)}
                                aria-controls="tags-collapse"
                                aria-expanded={openTags}
                            >
                                {openTags ? 'Show Less' : 'View All'}
                            </Button>
                            <Collapse in={openTags}>
                                <div id="tags-collapse">
                                    {tagList.slice(5).join(', ')}
                                </div>
                            </Collapse>
                        </>
                    )}
                </Card.Text>

                {/* Comments Section */}
                <Card.Text>
                    <strong>Comments:</strong> {commentList.slice(0, 3).join(', ')}
                    {commentList.length > 3 && (
                        <>
                            <Button
                                variant="link"
                                onClick={() => setOpenComments(!openComments)}
                                aria-controls="comments-collapse"
                                aria-expanded={openComments}
                            >
                                {openComments ? 'Show Less' : 'View All'}
                            </Button>
                            <Collapse in={openComments}>
                                <div id="comments-collapse">
                                    {commentList.slice(3).join(', ')}
                                </div>
                            </Collapse>
                        </>
                    )}
                </Card.Text>
            </Card.Body>
        </Card>
    );
};

export default HomePageCard;
