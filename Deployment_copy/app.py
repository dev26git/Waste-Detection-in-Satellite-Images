from PIL import Image
import streamlit as st
import cv2
import Main

st.set_page_config(page_title='SatellightSight', layout="wide")

with st.container():
    original_img, arrow, annotated_img = st.columns((5, 1, 5))
    with arrow:
        st.image("image_repo/Logo_of_Symbiosis_International_University.svg.png")
with st.container():
    original_img, arrow, annotated_img = st.columns((4, 6, 1))
    with arrow:
        st.subheader("Symbiosis Institute of Technology")

st.write("##")
st.write("##")
st.write("##")

# HEADER SECTION
st.title(":blue[SatellightSight] :satellite:")
# st.markdown("<h1 style='text-align: center; color: blue;'>SatellightSight</h1>", unsafe_allow_html=True)


st.write("##")
st.subheader('An automated machine learning approach to detect waste dumps in satellite images')
st.write("##")

# DISPLAY SAMPLE ANNOTATION
with st.container():
    original_img, arrow, annotated_img = st.columns((5, 1, 5))
    with original_img:
        st.image(Image.open("image_repo/sample_original_image.jpg"))
    with arrow:
        st.image(Image.open("image_repo/NavyBlueArrow.png"))
    with annotated_img:
        st.image(Image.open("image_repo/sample_annotated_image.jpg"))


st.write("##")
st.write("##")
st.write("##")
st.write("##")


# FILE UPLOAD
with st.container():
    st.subheader("**Upload a satellite image here**")
    file = st.file_uploader("", type=['jpeg', 'jpg', 'png'])


st.write("##")
st.write("##")


# MAIN CODE
if file is None:
    # st.text("Please upload an Image file")
    pass
else:
    # read image
    image_file = Image.open(file)
    image_file.save("input_image_file.jpg")

    img_bgr = cv2.imread("input_image_file.jpg")

    with st.container():
        st.subheader("Model Output")
        user_input, arrow, output_image = st.columns((5, 1, 5))
        # Print input image
        with user_input:
            st.image(image_file, use_column_width=True)
        with arrow:
            st.image(Image.open("image_repo/NavyBlueArrow.png"))

        annotated_output_image = Main.getAnnotatedImage(cv2.cvtColor(img_bgr, cv2.COLOR_BGR2RGB))

        # print annotated image
        with output_image:
            st.image(annotated_output_image)
