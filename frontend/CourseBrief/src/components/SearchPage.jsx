import React, { useEffect, useState} from 'react';
import { Container, Navbar, Nav, Button, Form, Row, Col, FormControl } from 'react-bootstrap';
import TagInput from './Tags';
import 'bootstrap/dist/css/bootstrap.min.css';
import { useNavigate } from 'react-router-dom';
import '../App.css';
import courseBrief from "../api/axios";
const SearchPage = () => {
    const [tags, setTags] = useState([]);
    const navigate = useNavigate();
   
    const handleSubmit = (event) => {
        event.preventDefault();  // Prevent the default form submission
        const ProfessorName = event.target.ProfessorName.value;
        const CourseName = event.target.CourseName.value;
        const Tags = tags;
        // Assuming TagInput uses something like `useState` to handle tags and passes them up via props or context
        // const Tags = event.target.Tags.value; // This might need adjustment based on how TagInput is implemented
        console.log('Professor:', ProfessorName);
        console.log('Course:', CourseName);
        console.log('Tags:', Tags);
    };

    useEffect(() => {
        courseBrief.get("/search/tags", {
            params: {
                label: "Design",
            }
        }).then(res => {
            setTags(res.data);
            console.log(res.data);
        }).catch(err => {
            console.error("you suck at coding")
        })
    }, []);
    return (
        <section className='section-style'>
            <Container className='container-style py-5'>
                <Row className='d-flex justify-content-center'>
                    <Col className='d-flex flex-column'>
                        <Col
                            className='d-flex flex-fill justify-content-center align-self-center my-5'
                            style={{ height: '12%', width: '60%' }}>
                            <h1 className='display-4 text-center fw-bold searchtitle'>Search Course</h1>
                        </Col>
                        <div className='d-flex justify-content-center align-items-center align-self-center m-5 form-container'>
                            <Col md={5} xl={6} className='text-center text-md-start'>
                                <Form method='post' data-bs-theme='light' onSubmit={handleSubmit}>
                                    <Row className='mb-4'>
                                        <Col xs={12} md={6}>
                                            <Form.Group>
                                                <FormControl
                                                    type='text'
                                                    name='ProfessorName'
                                                    placeholder='Profs Name'
                                                    className='shadow'
                                                />
                                            </Form.Group>
                                        </Col>
                                        <Col xs={12} md={6}>
                                            <Form.Group>
                                                <FormControl
                                                    type='text'
                                                    name='CourseName'
                                                    placeholder='Course Name'
                                                    className='shadow'
                                                />
                                            </Form.Group>
                                        </Col>
                                    </Row>
                                    <Col>
                                        <Form.Group className='mb-4'>
                                            <TagInput onTagsChange={setTags} />
                                        </Form.Group>
                                    </Col>

                                    <div className='d-flex justify-content-center mb-4'>
                                        <Button type='submit' className='btn-primary shadow button-login'>
                                            Search
                                        </Button>
                                    </div>
                                </Form>
                            </Col>
                        </div>
                    </Col>
                </Row>
            </Container>
        </section>
    );
};

export default SearchPage;
