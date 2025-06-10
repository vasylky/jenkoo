// job('seed-job') {
//     description('Seed Job to generate other jobs from DSL scripts')
    
//     // Parameters for the Seed Job
//     parameters {
//         stringParam('REPO_URL', 'https://github.com/vasylky/jenkoo.git', 'Git repository with DSL scripts')
//         stringParam('BRANCH_NAME', 'main', 'Git branch to fetch DSL scripts from')
//         stringParam('DSL_PATH', '**/*.groovy', 'Path pattern for DSL scripts (e.g., **/*.groovy)')
//         booleanParam('CLEAN_WORKSPACE', false, 'Clean workspace before running')
//         choiceParam('TARGET_ENV', ['dev', 'staging', 'prod'], 'Target environment for generated jobs')
//     }
    
//     // SCM configuration to fetch DSL scripts
//     scm {
//         git {
//             remote {
//                 url('${REPO_URL}')
//                 credentials('git-credentials-id')
//             }
//             branch('${BRANCH_NAME}')
//         }
//     }
    
//     // Triggers (optional, e.g., SCM polling)
//     triggers {
//         scm('H/15 * * * *') // Poll SCM every 15 minutes
//     }
    
//     // Build steps
//     steps {
//         // Clean workspace if requested
//         conditionalSteps {
//             condition { booleanCondition('CLEAN_WORKSPACE') }
//             steps { workspaceCleanup() }
//         }
        
//         // Process DSL scripts
//         dsl {
//             external('${DSL_PATH}')
//             removeAction('DELETE') // Options: IGNORE, DISABLE, DELETE
//             additionalParameters {
//                 props('''
//                     env = [:]
//                     env.TARGET_ENV = "${TARGET_ENV}"
//                 ''')
//             }
//         }
//     }
    
//     // Publishers (post-build actions)
//     publishers {
//         archiveArtifacts {
//             pattern('**/*.log')
//             allowEmpty(true)
//         }
//         mailer('vasylbalakym@gmail.com', false, true)
//     }
// }