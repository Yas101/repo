package teammates.ui.controller;

import static teammates.common.util.Const.ActionURIs.*;

import java.util.HashMap;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import teammates.common.exception.PageNotFoundException;
import teammates.common.util.Utils;

/**
 * Is used to generate the matching {@link Action} for a given URI.
 */
/**
 * Is used to generate the matching {@link Action} for a given URI.
 */
public class ActionFactory {
    protected static Logger log = Utils.getLogger();
    
    private static HashMap<String, Class<? extends Action>> actionMappings = new HashMap<String, Class<? extends Action>>();
    
    static{
        map(ADMIN_HOME_PAGE, AdminHomePageAction.class);
        map(ADMIN_ACCOUNT_DELETE, AdminAccountDeleteAction.class);
        map(ADMIN_ACTIVITY_LOG_PAGE, AdminActivityLogPageAction.class);
        map(ADMIN_ACCOUNT_DETAILS_PAGE, AdminAccountDetailsPageAction.class);
        map(ADMIN_ACCOUNT_MANAGEMENT_PAGE, AdminAccountManagementPageAction.class);
        map(ADMIN_EXCEPTION_TEST, AdminExceptionTestAction.class);
        map(ADMIN_INSTRUCTORACCOUNT_ADD, AdminInstructorAccountAddAction.class);
        map(ADMIN_SESSIONS_PAGE,AdminSessionsPageAction.class);
        map(ADMIN_SEARCH_PAGE, AdminSearchPageAction.class);
        map(ADMIN_STUDENT_GOOGLE_ID_RESET, AdminStudentGoogleIdResetAction.class);
        
        map(INSTRUCTOR_COURSES_PAGE, InstructorCoursesPageAction.class);
        map(INSTRUCTOR_COURSE_ADD, InstructorCourseAddAction.class);
        map(INSTRUCTOR_COURSE_DELETE, InstructorCourseDeleteAction.class);
        map(INSTRUCTOR_COURSE_ARCHIVE, InstructorCourseArchiveAction.class);
        map(INSTRUCTOR_COURSE_DETAILS_PAGE, InstructorCourseDetailsPageAction.class);
        map(INSTRUCTOR_COURSE_JOIN, InstructorCourseJoinAction.class);
        map(INSTRUCTOR_COURSE_JOIN_AUTHENTICATED, InstructorCourseJoinAuthenticatedAction.class);
        map(INSTRUCTOR_COURSE_REMIND, InstructorCourseRemindAction.class);
        map(INSTRUCTOR_COURSE_EDIT_PAGE, InstructorCourseEditPageAction.class);
        map(INSTRUCTOR_COURSE_INSTRUCTOR_ADD, InstructorCourseInstructorAddAction.class);
        map(INSTRUCTOR_COURSE_INSTRUCTOR_EDIT_SAVE, InstructorCourseInstructorEditSaveAction.class);
        map(INSTRUCTOR_COURSE_INSTRUCTOR_DELETE, InstructorCourseInstructorDeleteAction.class);
        map(INSTRUCTOR_COURSE_ENROLL_PAGE, InstructorCourseEnrollPageAction.class);
        map(INSTRUCTOR_COURSE_ENROLL_SAVE, InstructorCourseEnrollSaveAction.class);
        map(INSTRUCTOR_COURSE_STUDENT_DELETE, InstructorCourseStudentDeleteAction.class);
        map(INSTRUCTOR_COURSE_STUDENT_LIST_DOWNLOAD, InstructorCourseStudentListDownloadAction.class);
        map(INSTRUCTOR_COURSE_STUDENT_DETAILS_PAGE, InstructorCourseStudentDetailsPageAction.class);
        map(INSTRUCTOR_COURSE_STUDENT_DETAILS_EDIT, InstructorCourseStudentDetailsEditPageAction.class);
        map(INSTRUCTOR_COURSE_STUDENT_DETAILS_EDIT_SAVE, InstructorCourseStudentDetailsEditSaveAction.class);
        map(INSTRUCTOR_EDIT_STUDENT_FEEDBACK_PAGE, InstructorEditStudentFeedbackPageAction.class);
        map(INSTRUCTOR_EDIT_STUDENT_FEEDBACK_SAVE, InstructorEditStudentFeedbackSaveAction.class);
        map(INSTRUCTOR_EVALS_PAGE, InstructorEvalsPageAction.class);
        map(INSTRUCTOR_EVAL_ADD, InstructorEvalAddAction.class);
        map(INSTRUCTOR_EVAL_DELETE, InstructorEvalDeleteAction.class);
        map(INSTRUCTOR_EVAL_RESULTS_DOWNLOAD, InstructorEvalResultsDownloadAction.class);
        map(INSTRUCTOR_EVAL_EDIT_PAGE, InstructorEvalEditPageAction.class);
        map(INSTRUCTOR_EVAL_EDIT_SAVE, InstructorEvalEditSaveAction.class);
        map(INSTRUCTOR_EVAL_PREVIEW, InstructorEvalPreviewAction.class);
        map(INSTRUCTOR_EVAL_PUBLISH, InstructorEvalPublishAction.class);
        map(INSTRUCTOR_EVAL_REMIND, InstructorEvalRemindAction.class);
        map(INSTRUCTOR_EVAL_RESULTS_PAGE, InstructorEvalResultsPageAction.class);
        map(INSTRUCTOR_EVAL_STATS_PAGE, EvaluationStatsPageAction.class);
        map(INSTRUCTOR_EVAL_SUBMISSION_EDIT, InstructorEvalSubmissionEditPageAction.class);
        map(INSTRUCTOR_EVAL_SUBMISSION_EDIT_SAVE, InstructorEvalSubmissionEditSaveAction.class);
        map(INSTRUCTOR_EVAL_SUBMISSION_PAGE, InstructorEvalSubmissionPageAction.class);
        map(INSTRUCTOR_EVAL_UNPUBLISH, InstructorEvalUnpublishAction.class);
        map(INSTRUCTOR_FEEDBACKS_PAGE, InstructorFeedbacksPageAction.class);
        map(INSTRUCTOR_FEEDBACK_ADD, InstructorFeedbackAddAction.class);
        map(INSTRUCTOR_FEEDBACK_COPY, InstructorFeedbackCopyAction.class);
        map(INSTRUCTOR_FEEDBACK_DELETE, InstructorFeedbackDeleteAction.class);
        map(INSTRUCTOR_FEEDBACK_EDIT_COPY_PAGE, InstructorFeedbackEditCopyPageAction.class);
        map(INSTRUCTOR_FEEDBACK_EDIT_COPY, InstructorFeedbackEditCopyAction.class);
        map(INSTRUCTOR_FEEDBACK_EDIT_PAGE, InstructorFeedbackEditPageAction.class);
        map(INSTRUCTOR_FEEDBACK_EDIT_SAVE, InstructorFeedbackEditSaveAction.class);
        map(INSTRUCTOR_FEEDBACK_REMIND, InstructorFeedbackRemindAction.class);
        map(INSTRUCTOR_FEEDBACK_REMIND_PARTICULAR_STUDENTS_PAGE, InstructorFeedbackRemindParticularStudentsPageAction.class);
        map(INSTRUCTOR_FEEDBACK_REMIND_PARTICULAR_STUDENTS, InstructorFeedbackRemindParticularStudentsAction.class);
        map(INSTRUCTOR_FEEDBACK_PUBLISH, InstructorFeedbackPublishAction.class);
        map(INSTRUCTOR_FEEDBACK_UNPUBLISH, InstructorFeedbackUnpublishAction.class);
        map(INSTRUCTOR_FEEDBACK_QUESTION_ADD, InstructorFeedbackQuestionAddAction.class);
        map(INSTRUCTOR_FEEDBACK_QUESTION_COPY, InstructorFeedbackQuestionCopyAction.class);
        map(INSTRUCTOR_FEEDBACK_QUESTION_EDIT, InstructorFeedbackQuestionEditAction.class);
        map(INSTRUCTOR_FEEDBACK_QUESTION_VISIBILITY_MESSAGE, InstructorFeedbackQuestionVisibilityMessageAction.class);
        map(INSTRUCTOR_FEEDBACK_RESULTS_PAGE, InstructorFeedbackResultsPageAction.class);
        map(INSTRUCTOR_FEEDBACK_RESULTS_AJAX_RESPONSE_RATE, InstructorFeedbackResultsResponseRatePageAction.class);
        map(INSTRUCTOR_FEEDBACK_RESULTS_DOWNLOAD, InstructorFeedbackResultsDownloadAction.class);
        map(INSTRUCTOR_FEEDBACK_RESPONSE_COMMENT_ADD, InstructorFeedbackResponseCommentAddAction.class);
        map(INSTRUCTOR_FEEDBACK_RESPONSE_COMMENT_EDIT, InstructorFeedbackResponseCommentEditAction.class);
        map(INSTRUCTOR_FEEDBACK_RESPONSE_COMMENT_DELETE, InstructorFeedbackResponseCommentDeleteAction.class);
        map(INSTRUCTOR_FEEDBACK_RESPONSE_COMMENTS_LOAD, InstructorFeedbackResponseCommentsLoadAction.class);
        map(INSTRUCTOR_FEEDBACK_PREVIEW_ASSTUDENT, InstructorFeedbackPreviewAsStudentAction.class);
        map(INSTRUCTOR_FEEDBACK_PREVIEW_ASINSTRUCTOR, InstructorFeedbackPreviewAsInstructorAction.class);
        map(INSTRUCTOR_FEEDBACK_STATS_PAGE, FeedbackSessionStatsPageAction.class);
        map(INSTRUCTOR_FEEDBACK_SUBMISSION_EDIT_PAGE, InstructorFeedbackSubmissionEditPageAction.class);
        map(INSTRUCTOR_FEEDBACK_SUBMISSION_EDIT_SAVE, InstructorFeedbackSubmissionEditSaveAction.class);
        map(INSTRUCTOR_FEEDBACK_QUESTION_SUBMISSION_EDIT_PAGE, InstructorFeedbackQuestionSubmissionEditPageAction.class);
        map(INSTRUCTOR_FEEDBACK_QUESTION_SUBMISSION_EDIT_SAVE, InstructorFeedbackQuestionSubmissionEditSaveAction.class);
        map(INSTRUCTOR_HOME_PAGE, InstructorHomePageAction.class);
        map(INSTRUCTOR_SEARCH_PAGE, InstructorSearchPageAction.class);
        map(INSTRUCTOR_STUDENT_LIST_PAGE, InstructorStudentListPageAction.class);
        map(INSTRUCTOR_STUDENT_LIST_AJAX_PAGE, InstructorStudentListAjaxPageAction.class);
        map(INSTRUCTOR_STUDENT_RECORDS_PAGE, InstructorStudentRecordsPageAction.class);
        
        map(INSTRUCTOR_STUDENT_COMMENT_ADD, InstructorStudentCommentAddAction.class);
        map(INSTRUCTOR_STUDENT_COMMENT_EDIT, InstructorStudentCommentEditAction.class);
        map(INSTRUCTOR_STUDENT_COMMENT_CLEAR_PENDING, InstructorStudentCommentClearPendingAction.class);
        map(INSTRUCTOR_COMMENTS_PAGE, InstructorCommentsPageAction.class);

        map(STUDENT_COMMENTS_PAGE, StudentCommentsPageAction.class);
        map(STUDENT_COURSE_DETAILS_PAGE, StudentCourseDetailsPageAction.class);
        map(STUDENT_COURSE_JOIN, StudentCourseJoinAction.class);
        map(STUDENT_COURSE_JOIN_NEW, StudentCourseJoinAction.class);
        map(STUDENT_COURSE_JOIN_AUTHENTICATED, StudentCourseJoinAuthenticatedAction.class);
        map(STUDENT_EVAL_SUBMISSION_EDIT_PAGE, StudentEvalSubmissionEditPageAction.class);
        map(STUDENT_EVAL_RESULTS_PAGE, StudentEvalResultsPageAction.class);
        map(STUDENT_EVAL_SUBMISSION_EDIT_SAVE, StudentEvalSubmissionEditSaveAction.class);
        map(STUDENT_FEEDBACK_RESULTS_PAGE, StudentFeedbackResultsPageAction.class);
        map(STUDENT_FEEDBACK_SUBMISSION_EDIT_PAGE, StudentFeedbackSubmissionEditPageAction.class);
        map(STUDENT_FEEDBACK_SUBMISSION_EDIT_SAVE, StudentFeedbackSubmissionEditSaveAction.class);
        map(STUDENT_FEEDBACK_QUESTION_SUBMISSION_EDIT_PAGE, StudentFeedbackQuestionSubmissionEditPageAction.class);
        map(STUDENT_FEEDBACK_QUESTION_SUBMISSION_EDIT_SAVE, StudentFeedbackQuestionSubmissionEditSaveAction.class);
        map(STUDENT_PROFILE_PAGE, StudentProfilePageAction.class);
        map(STUDENT_PROFILE_PICTURE, StudentProfilePictureAction.class);
        map(STUDENT_PROFILE_PICTURE_UPLOAD, StudentProfilePictureUploadAction.class);
        map(STUDENT_PROFILE_PICTURE_EDIT, StudentProfilePictureEditAction.class);
        map(STUDENT_PROFILE_CREATEUPLOADFORMURL, StudentProfileCreateFormUrlAction.class);
        map(STUDENT_PROFILE_EDIT_SAVE, StudentProfileEditSaveAction.class);
        map(STUDENT_HOME_PAGE, StudentHomePageAction.class);
    }



    /**
     * @return the matching {@link Action} object for the URI in the {@code req}.
     *   The returned {@code Action} is already initialized using the {@code req}.
     */
    public Action getAction(HttpServletRequest req) {
        
        String url = req.getRequestURL().toString();
        log.info("URL received :" + url);
        
        String uri = req.getRequestURI();
        if (uri.contains(";")) {
            uri = uri.split(";")[0];
        }
        Action c = getAction(uri);
        c.init(req);
        return c;
        
    }

    private static Action getAction(String uri) {
        Class<? extends Action> controllerClass = actionMappings.get(uri);
        
        if(controllerClass == null){
            throw new PageNotFoundException(uri);
        }
        
        try {
            return controllerClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Could not create the action for :" + uri);
        }
        
    }

    private static void map(String actionUri, Class<? extends Action> actionClass) {
        actionMappings.put(actionUri, actionClass);
    }

}
