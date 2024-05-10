INSERT INTO Admin (adminid, username, password)
VALUES 
('ADMIN1', 'nick-admin', '$2a$10$SbdYm4X8/9.Lqv9BY.UOy.ZzPZkP8vhSVMpbCqTKL1.mKkvmPDnNq');

INSERT INTO Professor (professorID, first_name, last_name)
VALUES 
('PROF1', 'John', 'Doe'),
('PROF2', 'Jane', 'Smith');


INSERT INTO Tag (tagID, Label)
VALUES 
('TAG1', 'DFS'),
('TAG2', 'Radix Sort'),
('TAG3', 'Java'),
('TAG4', 'Python'),
('TAG5', 'C++'),
('TAG6', 'Algorithms'),
('TAG7', 'Data Structures'),
('TAG8', 'Object-Oriented Programming'),
('TAG9', 'Functional Programming'),
('TAG10', 'Database Design'),
('TAG11', 'SQL'),
('TAG12', 'NoSQL'),
('TAG13', 'Computer Networks'),
('TAG14', 'Web Development'),
('TAG15', 'Mobile Development'),
('TAG16', 'Artificial Intelligence'),
('TAG17', 'Machine Learning'),
('TAG18', 'Data Mining'),
('TAG19', 'Big Data'),
('TAG20', 'Cloud Computing'),
('TAG21', 'Operating Systems'),
('TAG22', 'Concurrency'),
('TAG23', 'Parallel Processing'),
('TAG24', 'Software Engineering'),
('TAG25', 'Version Control'),
('TAG26', 'Agile Development'),
('TAG27', 'Software Testing'),
('TAG28', 'User Interface Design'),
('TAG29', 'User Experience Design'),
('TAG30', 'Cybersecurity'),
('TAG31', 'Cryptography'),
('TAG32', 'Blockchain'),
('TAG33', 'Game Development'),
('TAG34', 'Virtual Reality'),
('TAG35', 'Augmented Reality'),
('TAG36', 'Human-Computer Interaction'),
('TAG37', 'Bioinformatics'),
('TAG38', 'Data Visualization'),
('TAG39', 'Compiler Design'),
('TAG40', 'Embedded Systems');



INSERT INTO Class (classID, class_name)
VALUES 
('CLASS1', 'Introduction to Programming'),
('CLASS2', 'Introduction to Data Structures'),
('CLASS3', 'Introduction to Computer Systems'),
('CLASS4', 'Data Structures and Algorithms'),
('CLASS5', 'Computer Architecture'),
('CLASS6', 'Operating Systems'),
('CLASS7', 'Object-Oriented Design'),
('CLASS8', 'Programming Paradigms'),
('CLASS9', 'Software Engineering'),
('CLASS10', 'Database Systems'),
('CLASS11', 'Computer Networks'),
('CLASS12', 'Machine Learning'),
('CLASS13', 'Artificial Intelligence'),
('CLASS14', 'Web Development'),
('CLASS15', 'Mobile Development'),
('CLASS16', 'Big Data'),
('CLASS17', 'Cloud Computing'),
('CLASS18', 'Cybersecurity'),
('CLASS19', 'Software Testing'),
('CLASS20', 'User Interface Design');



INSERT INTO Course (courseID, professorID, classID)
VALUES 
('COURSE1', 'PROF1', 'CLASS1'),
('COURSE2', 'PROF1', 'CLASS2'),
('COURSE3', 'PROF1', 'CLASS3'),
('COURSE4', 'PROF1', 'CLASS4'),
('COURSE5', 'PROF1', 'CLASS5'),
('COURSE6', 'PROF1', 'CLASS6'),
('COURSE7', 'PROF1', 'CLASS7'),
('COURSE8', 'PROF1', 'CLASS8'),
('COURSE9', 'PROF1', 'CLASS9'),
('COURSE10', 'PROF1', 'CLASS10'),
('COURSE11', 'PROF1', 'CLASS11'),
('COURSE12', 'PROF1', 'CLASS12'),
('COURSE13', 'PROF1', 'CLASS13'),
('COURSE14', 'PROF1', 'CLASS14'),
('COURSE15', 'PROF1', 'CLASS15'),
('COURSE16', 'PROF1', 'CLASS16'),
('COURSE17', 'PROF1', 'CLASS17'),
('COURSE18', 'PROF1', 'CLASS18'),
('COURSE19', 'PROF1', 'CLASS19'),
('COURSE20', 'PROF1', 'CLASS20');


INSERT INTO course_tag (courseID, tagID)
VALUES 
('COURSE1', 'TAG3'),
('COURSE1', 'TAG7'),
('COURSE2', 'TAG4'),
('COURSE2', 'TAG6'),
('COURSE2', 'TAG7'),
('COURSE3', 'TAG21'),
('COURSE4', 'TAG6'),
('COURSE4', 'TAG7'),
('COURSE4', 'TAG9'),
('COURSE5', 'TAG21'),
('COURSE6', 'TAG21'),
('COURSE6', 'TAG22'),
('COURSE7', 'TAG8'),
('COURSE7', 'TAG24'),
('COURSE7', 'TAG26'),
('COURSE8', 'TAG26'),
('COURSE8', 'TAG36'),
('COURSE8', 'TAG24'),
('COURSE9', 'TAG24'),
('COURSE9', 'TAG36'),
('COURSE9', 'TAG8'),
('COURSE10', 'TAG10'),
('COURSE10', 'TAG11'),
('COURSE10', 'TAG12'),
('COURSE11', 'TAG13'),
('COURSE11', 'TAG35'),
('COURSE11', 'TAG34'),
('COURSE12', 'TAG16'),
('COURSE12', 'TAG17'),
('COURSE12', 'TAG18'),
('COURSE12', 'TAG19'),
('COURSE13', 'TAG16'),
('COURSE13', 'TAG17'),
('COURSE13', 'TAG18'),
('COURSE13', 'TAG19'),
('COURSE14', 'TAG14'),
('COURSE14', 'TAG28'),
('COURSE14', 'TAG29'),
('COURSE15', 'TAG15'),
('COURSE15', 'TAG28'),
('COURSE15', 'TAG29'),
('COURSE16', 'TAG19'),
('COURSE16', 'TAG18'),
('COURSE16', 'TAG14'),
('COURSE17', 'TAG20'),
('COURSE17', 'TAG36'),
('COURSE17', 'TAG37'),
('COURSE18', 'TAG30'),
('COURSE18', 'TAG31'),
('COURSE19', 'TAG27'),
('COURSE19', 'TAG30'),
('COURSE19', 'TAG37'),
('COURSE20', 'TAG28'),
('COURSE20', 'TAG37'),
('COURSE20', 'TAG36');


